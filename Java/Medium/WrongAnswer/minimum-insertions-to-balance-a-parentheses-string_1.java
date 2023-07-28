class Solution {
    public int minInsertions(String s) {
        
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                if (right % 2 == 1) {
                    ans++;
                    right--;
                }
            } else {
                right++;
                if (right == 2) {
                    left--;
                    right = 0;
                }
            }
        }
        ans += left * 2;
        ans += right;
        return ans;
    }
}