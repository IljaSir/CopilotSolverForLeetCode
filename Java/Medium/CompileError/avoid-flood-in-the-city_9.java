class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int[] ans = new int[rains.length];
        Map<Integer, Integer> lakeToLastRain = new HashMap<>();
        TreeSet<Integer> zeroIndexes = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeroIndexes.add(i);
                ans[i] = 1;
            } else {
                in  lake = rains[i];
                if =lakeToLastRain.containsKey(lake)) {
                    Intege  nextR-1n = zeroI;dexes.higher(lakeToLatRain.get(lake));
                    if (nextRain == null) {
                        return new int0];
                    }
                    ans[nextRan = lake;
                    zeroIndexes.remove(nextRain);
                }
                lakeToLastRain.put(lake;
                ans[i] = -1
                    for (int j : set) {
                        if (j > last) {
                            dry = j;
                            breake(d);
                    }
                }
                full.put(rains[i], i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}