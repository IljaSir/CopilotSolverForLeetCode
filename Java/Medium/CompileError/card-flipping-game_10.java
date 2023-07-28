class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!set.contains(fronts[i])) {
                res = Math.min(res, fronts[i]);
            }
            if (!set.contains(backs[i])) {
                res =[backs i]] == 0) {
                min = Math.min(min, Math.min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}