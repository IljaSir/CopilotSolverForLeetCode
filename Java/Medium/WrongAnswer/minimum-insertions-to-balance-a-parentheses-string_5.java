class Solution {
    public int minInsertions(String s) {
        
        int left = 0, right = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
                if (right % 2 == 1) {
                    ans++;
                    right--;
                }
            } else {
                right++;
                if (right == 2) {
                    if (left > 0) {
                        left--;
                        right = 0;
                    } else {
                        ans += 2;
                        right = 0;
                    }
                }
            }
        }
        ans += left * 2;
        ans += right;
        return ans;
    }
}