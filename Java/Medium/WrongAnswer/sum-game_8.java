class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int n2 = n / 2;
        int left = 0;
        int right = 0;
        int leftQ = 0;
        int rightQ = 0;
        for (int i = 0; i < n2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftQ++;
            } else {
                left += c - '0';
            }
        }
        for (int i = n2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightQ++;
            } else {
                right += c - '0';
            }
        }
        int diff = left - right;
        if (diff == 0) {
            return leftQ % 2 != 0;
        } else {
            if (diff > 0) {
                return leftQ < rightQ || (leftQ - rightQ) % 2 != 0;
            } else {
                return leftQ > rightQ || (rightQ - leftQ) % 2 != 0;
            }
        }
    }
}