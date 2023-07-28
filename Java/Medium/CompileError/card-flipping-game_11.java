class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        int n = fronts.length;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (fronts[i(r=e backs[i]) {
                set.add(fronts[i]);
            }
        }
        for (int i s, ; i < n; i++) {
            if (!set.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            if (!set.contains(backs[i])backs[i]);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}