class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0, cost = 0, res = 0;
        while (end < n) {
            cost += diff[end];
            while (cost > maxCost) {
                cost -= diff[start];
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}