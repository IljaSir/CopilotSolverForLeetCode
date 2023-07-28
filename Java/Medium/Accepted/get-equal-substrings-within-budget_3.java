class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0;
        int max = 0;
        int sum = 0;
        while (right < n) {
            sum += costs[right];
            while (sum > maxCost) {
                sum -= costs[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}