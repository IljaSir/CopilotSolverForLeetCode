class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0, sum = 0, max = 0;
        while (end < s.length()) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}