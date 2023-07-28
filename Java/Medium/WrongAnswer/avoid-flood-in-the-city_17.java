class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        // 1. Store the days that rain over the lake.
        Map<Integer, Integer> lastRainDay = new HashMap<>();
        // 2. Store the days that are empty.
        TreeSet<Integer> emptyDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                emptyDays.add(i);
                continue;
            }
            
            // If the lake is full.
            if (lastRainDay.containsKey(lake)) {
                // Find the first day that is empty and after the last rain day.
                Integer dryDay = emptyDays.ceiling(lastRainDay.get(lake));
                if (dryDay == null) {
                    // No empty day after the last rain day.
                    return new int[0];
                }
                ans[dryDay] = lake;
                emptyDays.remove(dryDay);
            }
            
            ans[i] = -1;
            lastRainDay.put(lake, i);
        }
        
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                ans[i] = 1;
            }
        }
        
        return ans;
    }
}