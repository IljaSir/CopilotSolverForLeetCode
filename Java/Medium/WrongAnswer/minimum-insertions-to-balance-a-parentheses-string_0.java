class Solution {
    public int minInsertions(String s) {
        
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                if (right == 1) {
                    ans += 1;
                    right = 0;
                }
            } else {
                if (right == 1) {
                    right = 0;
                    ans += 1;
                } else {
                    right = 1;
                }
                if (left > 0) {
                    left--;
                } else {
                    ans += 1;
                }
            }
        }
        ans += left * 2 + right;
        return ans;
    }
}