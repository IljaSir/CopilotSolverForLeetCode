class Solution {
    public int largestComponentSize(int[] nums) {
        
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, i);
                    } else {
                        uf.union(i, map.get(j));
                    }
                    if (!map.containsKey(x / j)) {
                        map.put(x / j, i);
                    } else {
                        uf.union(i, map.get(x / j));
                    }
                }
            }
            if (!map.containsKey(x)) {
                map.put(x, i);
            } else {
                uf.union(i, map.get(x));
            }
        }
        return uf.maxSize;
    }
}
    }
}