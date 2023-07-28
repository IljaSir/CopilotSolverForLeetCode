class Solution {
    public int[] avoidFlood(int[] rains) {
        
        Map<Integer, Integer> full = new HashMap();
        TreeSet<Integer> dry = new TreeSet();
        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (full.containsKey(rains[i])) {
                    Integer dryDay = dry.ceiling(full.get(rains[i]));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = rains[i];
                    dry.remove(dryDay);
                }
                full.put(rains[i], i);
                ans[i] = -1;
            } else {
                dry.add(i);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}