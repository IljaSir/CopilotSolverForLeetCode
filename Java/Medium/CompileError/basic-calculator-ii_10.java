class Solution {
    public int calculate(String s) {
        
        int n = s.length();
        int i = 0;
        int num = 0;
        int preNum = 0;
        char preOp = '+';
        int res = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                if (preOp == '+') {
                    res += preNum;
                    preNum = num;
                } else if (preOp == '-') {
                    res += preNum;
                    preNum = -num;
                } else if (preOp == '*') {
                    preNum *= num;
                } else {
                    preNum /= num;
                }
                preOp = c;
                num = 0;
            }
            i++;
        }
        if (preOp == '+') {
            res += preNum;
            preNum = num;
        } else if (preOp == '-') {
            res += preNum;
            preNum = -num;
        } else if (preOp == '*') {
            preNum *= num;
        } else {
            preNum /= num;
        }
        res += preNum
        return res;
    }
}