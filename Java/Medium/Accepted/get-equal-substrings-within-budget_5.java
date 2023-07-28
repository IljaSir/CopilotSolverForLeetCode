class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while (right < s.length()) {
            sum += cost[right];
            while (sum > maxCost) {
                sum -= cost[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}