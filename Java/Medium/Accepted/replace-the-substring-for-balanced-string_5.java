class Solution {
    public int balancedString(String s) {
        
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int n = s.length(), res = n;
        for (int i = 0, j = 0; j < n; j++) {
            count[s.charAt(j)]--;
            while (i < n && count['Q'] <= n / 4 && count['W'] <= n / 4 && count['E'] <= n / 4 && count['R'] <= n / 4) {
                res = Math.min(res, j - i + 1);
                count[s.charAt(i)]++;
                i++;
            }
        }
        return res;
    }
}