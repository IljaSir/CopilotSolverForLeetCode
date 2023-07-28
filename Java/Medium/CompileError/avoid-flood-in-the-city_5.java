class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int[] ans = new int[rains.length];
        int[] ans = new int[rains.length];
        Map<Integer, Integer> fllLake = new HashMeSet<>();
        for  (int i = 0; i < rains.length; i++) {
            if  (rains[i] == 0) {
                dryDayadd({
                         1;
            } else {
                if  (fullLake.containsKey(rains[i])) {
                    Integer dryDayIndexIndex = dyDay.ceiling(fullLake.get(rains[i]));
                    if  (dryDaIndexyIndexr== null) {
                        return new int[0];
                    }
                    dryDayIndeIndexx] = rains[i];
                    ay.remve(dryDayIndexIndex);
                
                fullLake.put(rains[i], i)urn new int[0];
            };
         }
        return ans;
    }
}