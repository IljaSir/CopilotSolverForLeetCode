class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0, cost = 0, max = 0;
        while (end < n) {
            cost += costs[end++];
            while (cost > maxCost) {
                cost -= costs[start++];
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}