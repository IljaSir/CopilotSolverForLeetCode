class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int[] ans = new int[rains.length];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
            } else {
                if (fullLakes.containsKey(rains[i])) {
                    Integer nextDryDay = dryDays.ceiling(fullLakes.get(rains[i]));
                    if (nextDryDay == null) {
                        return new int[0];
                    }
                    ans[nextDryDay] = rains[i];
                    dryDays.remove(nextDryDay);
                }
                ans[i] = -1;
                fullLakes.put(rains[i], i);
            }
        }
        for (int dryDay : d;
            }
        }
        return ans;
    }
}