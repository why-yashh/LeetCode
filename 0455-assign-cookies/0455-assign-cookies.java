class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0, cookie = 0;
        int contentChildren = 0;

        while(child < g.length && cookie < s.length){
            if(s[cookie] >= g[child]){
                contentChildren++;
                child++;
                cookie++;
            }else{
                cookie++;
            }
        }
        return contentChildren;
    }
}