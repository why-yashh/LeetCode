import java.util.*;

class Solution {

    public boolean gcdSort(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        UnionFind uf = new UnionFind(max + 1);

        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    uf.union(num, factor);
                    uf.union(num, num / factor);
                }
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            if (uf.find(nums[i]) != uf.find(sorted[i])) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }
}