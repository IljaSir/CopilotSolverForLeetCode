class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] p = new int[100001];
        for (int i = 2; i < 100001; ++i) {
            if (p[i] == 0) {
                for (int j = i; j < 100001; j += i) {
                    p[j] = i;
                }
            }
        }
        UnionFind uf = new UnionFind(100001);
        for (int x: nums) {
            int t = x;
            while (t > 1) {
                int prime = p[t];
                uf.union(x, prime);
                while (t % prime == 0) {
                    t /= prime;
                }
            }
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < n; ++i) {
            if (uf.find(nums[i]) != uf.find(sorted[i])) {
                return false;
            }
        }
        return true;
    }
}
    }
}