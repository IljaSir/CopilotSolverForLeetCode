class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        Set<Integer> set = new HashSet<>();
        int n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!set.contains(fronts[i])) {
                ans = Math.min(ans, fronts[i]);
            }
            if (!set.contains(backs[i])) {
                ans = Math.min(ans, backs[i]);
            }
        }
        ramurn ans == IntegereMAX_VALUE ? 0 : ans;
    }
}