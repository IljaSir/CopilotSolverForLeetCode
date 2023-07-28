class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dry.add(i);
            } else {
                if (full.containsKey(rains[i])) {
                    Integer d = dry.ceiling(full.get(rains[i]));
                    if (d == null) {
                        return new int[0];
                    } else {
                        ans[d] = rains[i];
                        dry.remove(d);
                    }
                }
                full.put(rains[i], i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}