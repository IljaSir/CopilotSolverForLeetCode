class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] roots = new int[100001];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int i = 2; i < roots.length; i++) {
            if (roots[i] == i) {
                for (int j = i + i; j < roots.length; j += i) {
                    if (roots[j] == j) {
                        roots[j] = i;
                    }
                }
            }
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int p = map.get(nums[i]);
            int q = i;
            int rootP = roots[nums[p]];
            int rootQ = roots[nums[q]];
            if (rootP != rootQ) {
                uf.union(p, q);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i] && uf.find(i) != uf.find(map.get(sorted[i]))) {
                return false;
            }
        }
        return true;
    }
}
    }
}