class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int max = 0;
        while (r < s.length()) {
            sum += diff[r];
            while (sum > maxCost) {
                sum -= diff[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}