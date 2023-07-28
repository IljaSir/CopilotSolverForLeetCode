class Solution {
    public int minimumTime(String s) {
        
        int n = s.length();
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i <= j) {
            if (s.charAt(i) == '1') {
                ans += 2;
                if (s.charAt(j) == '1') {
                    j--;
                }
            } else {
                ans += 1;
            }
            i++;
        }
        return ans - (j == n - 1 ? 1 : 0);
    }
}