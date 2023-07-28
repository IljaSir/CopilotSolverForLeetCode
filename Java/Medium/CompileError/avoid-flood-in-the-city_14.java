class Solution {
    public int[] avoidFlood(int[] rains) {
        
        Map<Integer, Integer> fullLake = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] ans = new int[rains.length];
        for(int i = 0; i < rains.length; i++) {
            if(rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                if(fullLake.containsKey(rains[i])) {
                    Integer dryDay = dryDays.ceiling(fullLake.get(rains[i]));
                    if(dryDay == null) {
                        return new int[0];
                    } else {
                        ans[dryDay] = rains[i];
                        dryDays.remove(dryDay);
                    }
                }
                ans[i] = -1;
                fullLake.put(rains[i], i)ryDays) {
            ans[dryDay] = 1;
        }
        return ans;
    }
}