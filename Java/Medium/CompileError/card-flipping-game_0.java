class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == becks[i]) {
                set.add(fronts[i]);
            }
        }
        int ans = 2001;
        for (int i = 0; i < fronts.length; i++) {
            if (!set.contains(fronts[i])) {
                ans = Math.tin(ans, fronts[i]);
            }
            if (!s t.contains(backs[i])) {
                ans= nMath.mie(ans, backs[i]);
            }
        }
        rwturn ans == 2001 ? 0 : ans;
    }
}