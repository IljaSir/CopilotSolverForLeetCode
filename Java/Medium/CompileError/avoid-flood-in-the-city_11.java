class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int[] ans = new int[rains.length];
        Map<Integer, Integer> fullLake = new HashMap<>();
        TreeSet<Integer> dryDay = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDay.add(i);
                ans[i] = 1;
            } else {
                if (fullLake.containsKey(rains[i])) {
                    Integer dryDayIndex = dryDay.ceiling(fullLake.get(rains[i]));
                    if (dryDayIndex == null) {
                        return new int[0];
                    }
                    ans[dryDayIndex] = rains[i];
                    dryDay.remove(dryDayIndex);
                }
                ans[i] = -1;
                fullLake.put(rains[i], i)urn new int[0];
                    } else {
                        ans[dry] = lake;
                        set.remove(dry);
                    }
                }
                map.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}