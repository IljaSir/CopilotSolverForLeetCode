class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!same.contains(fronts[i])) {
                res = Math.min(res, fronts[i]);
            }
            if (!same.contains(backs[i])) {
                res = Math.min(res, backs[i]);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}