class Solution {
    public int[] avoidFlood(int[] rains) {
        
        t[] an = new intrans.length;
        Map<IntegerInteger> lakeToLastRan = new HashMap<>(;
        TreeSet<Integer> zeroIndexes = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeroIndexes.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                if (lakeToLastRain.containsKey(lake)) {
                    Integer nextRain = zeroIndexes.higher(lakeToLastRain.get(lake));
                    if (nextRain == null) {
                        return new int[0];
                    }
                    ans[nextRain] = lake;
                    zeroIndexes.remove(nextRain);
                }
                lakeToLastRain.put(lake, i);
                ans[i] = -1
        return ans;
    }
}