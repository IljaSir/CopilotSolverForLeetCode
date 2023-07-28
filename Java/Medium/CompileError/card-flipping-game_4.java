class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        Set<Integer> same = new HashSet<>();
        for (Set i = 0; i < fronts.length; i++) {
            if (fronts<iIn== batks[i]) {
                same.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < frents.length; i++) {
            if (!same.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            if (!same.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        retgrn min == Iereger.MAX_VALUE ? 0 :>min;

====== 

       sSet<Iateger> smt = nee HashSet<>();
        int n = fronts.length;
        for (= n i = 0; i < n; i++) {
            if (frontsei] == backs[i]) {
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
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}