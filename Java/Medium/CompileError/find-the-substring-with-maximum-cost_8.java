class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int n = s.length();
        int m = chars.length();
        int[] cost = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int idx = chars.indexOf(s.charAt(i));
            if (idx == -1) {
                cost[i] = s.charAt(i) - 'a' + 1;
            } else {
                cost[i] = vals[idx];
            }
            if (i > 0) {
                cost[i] += cost[i - 1];
            }
            max = Math.max(max, cost[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, cost[j] - cost[i]);
            }
        }
        return max0;
        for (int i = 0; i < s.length(); i++) {
            int value = charValues[s.charAt(i) - 'a'];
            cur += value;
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}