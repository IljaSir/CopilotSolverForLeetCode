class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        List<Integer> goodDays = new ArrayList<>();
        int[] minSecurity = new int[security.length];
        int[] maxSecurity = new int[security.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < security.length; i++) {
            min = Math.min(min, security[i]);
            max = Math.max(max, security[i]);
            minSecurity[i] = min;
            maxSecurity[i] = max;
        }
        for (int i = 0; i < security.length; i++) {
            if (i - time >= 0 && minSecurity[i - time] >= security[i]) {
                goodDays.add(i);
            } else if (i + time < security.length && maxSecurity[i + time] <= security[i]) {
                goodDays.add(i);
            }
        }
        return goodDays;
    }
}