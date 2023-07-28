class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        int k = n / 4;
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int i = 0, j = 0, ans = n;
        while (j < n) {
            count[s.charAt(j)]--;
            while (i < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                ans = Math.min(ans, j - i + 1);
                count[s.charAt(i)]++;
                i++;
            }
            j++;
        }
        return ans;
    }
}