class Solution {
    public int minInsertions(String s) {
        
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                if (right % 2 == 1) {
                    res++;
                    right--;
                }
            } else {
                right++;
                if (right == 2) {
                    if (left > 0) {
                        left--;
                        right = 0;
                    } else {
                        res++;
                    }
                }
            }
        }
        return res + left * 2 + right;
    }
}