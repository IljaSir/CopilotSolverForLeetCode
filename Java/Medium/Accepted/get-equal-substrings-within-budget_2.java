class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0;
        int sum = 0;
        int maxLength = 0;
        while (right < n) {
            sum += diff[right];
            while (sum > maxCost) {
                sum -= diff[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}