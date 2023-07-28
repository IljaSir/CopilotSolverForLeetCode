class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        while (right < n) {
            sum += cost[right];
            while (sum > maxCost) {
                sum -= cost[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}