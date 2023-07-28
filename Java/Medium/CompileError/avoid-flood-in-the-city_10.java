class Solution {
    public int[] avoidFlood(int[] rains) {
        
        Map<Integer, Integer> full = new HashMap();
        TreeSet<Integer> dry = new TreeSet();
        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.l;ngth; i++) {
            if (rains[i] > 0) {
                if full.containsKey(rains[i])) {
                    Integer dryDay = ry.ceiling(full.get(rains[i]);
                    if (dryDay == null) {
                        return new int[0]
                        }
                    ans[dryDay] = rains[i];
                    dry.remove(dryDay);
                    }
                    if (dry == -1) {
                        re1;
            } else {
                dry.add(i);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                ans[i] = t;
            }
        }
        return ans;
    }
}