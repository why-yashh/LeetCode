class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        ArrayList<Integer>[] adj = new ArrayList[c];

        for(int i = 0; i < c; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : connections){
            int u = e[0]-1;
            int v = e[1]-1;

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] compId = new int[c];
        Arrays.fill(compId, -1);

        boolean[] isOnline = new boolean[c];
        Arrays.fill(isOnline, true);

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int componentId = 0;

        for(int i = 0; i < c; i++){
            if(compId[i] == -1){
                ArrayList<Integer> currComp = new ArrayList<>();
                dfs(i, componentId, compId, adj, currComp);
                Collections.sort(currComp);
                map.put(componentId, currComp);
                componentId++;
            }
        }

        int[] smallIndex = new int[c];

        int count = 0;
        for(int[] q : queries){
            if(q[0] == 1) count++;
        }

        int[] res = new int[count];
        int z = 0;

        for(int[] q : queries){
            int con = q[0];
            int u = q[1] - 1;
            int compoId = compId[u];

            if(con == 1) { 
                if(isOnline[u]){
                    res[z++] = u+1;
                }
                else{
                    ArrayList<Integer> compList = map.get(compoId);
                    int idx = smallIndex[compoId];

                    if(idx >= compList.size()){
                        res[z++] = -1;
                    } 
                    else{
                        res[z++] = compList.get(idx)+1;
                    }
                }
            }
            else if(con == 2){
                if(isOnline[u]){
                    isOnline[u] = false;
                    
                    ArrayList<Integer> compList = map.get(compoId);
                    int idx = smallIndex[compoId];

                    if(idx < compList.size() && compList.get(idx) == u){
                        while(idx < compList.size() && !isOnline[compList.get(idx)]) idx++;
                    }

                    smallIndex[compoId] = idx;
                }
            }
        }
        return res;
    }

    public void dfs(int u, int id, int[] compId, ArrayList<Integer>[] adj, ArrayList<Integer> currComp){
        if(compId[u] != -1) return;

        compId[u] = id;
        currComp.add(u);

        for(int v : adj[u]){
            dfs(v, id, compId, adj, currComp);
        }
    }
}