class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int pu = find(p, u), pv = find(p, v);
            if (pu != pv) p[pu] = pv;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int pi = find(p, i);
            map.putIfAbsent(pi, new ArrayList<>());
            map.get(pi).add(nums[i]);
        }
        int res = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            int cur = 0;
            for (int x : list) cur ^= x;
            res = Math.min(res, cur);
        }
        return res;
    }
}