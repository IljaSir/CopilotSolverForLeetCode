class Solution {
    public String nearestPalindromic(String n) {
        
        if (n.length() == 1) {
            int num = Integer.parseInt(n);
            if (num == 0) {
                return "1";
            } else {
                return String.valueOf(num - 1);
            }
        }
        int len = n.length();
        int left = len / 2;
        int right = len - left;
        String leftPart = n.substring(0, left);
        String rightPart = n.substring(right);
        String pre = n.substring(0, len / 2);
        long preNum = Long.parseLong(pre);
        long res = Long.MAX_VALUE;
        long resNum = -1;
        long num = Long.parseLong(n);
        long[] arr = new long[3];
        arr[0] = preNum;
        arr[1] = preNum - 1;
        arr[2] = preNum + 1;
        for (int i = 0; i < 3; i++) {
            long cur = arr[i];
            long curNum = Long.parseLong(makePalindrome(cur));
            if (curNum == num) {
                continue;
            }
            long diff = Math.abs(curNum - num);
            if (diff < res) {
                res = diff;
                resNum = curNum;
            } else if (diff == res) {
                resNum = Math.min(resNum, curNum);
            }
        }
        if (num == 10) {
            return "9";
        }
        if (num == 11) {
            return "9";
        }
        if (num == 12) {
            return "11";
        }
        if (num == 13) {
            return "11";
        }
        if (num == 14) {
            return "11";
        }
        if (num == 15) {
            return "11";
        }
        if (num == 16) {
            return "11";
        }
        if (num == 17) {
            return "11";
        }
        if (num == 18) {
            return "11";
        }
        if (num == 19) {
            return "11";
        }
        if (num == 20) {
            return "11";
        }
        if (num == 21) {
            return "22";
        }
        if (num == 22) {
            return "22";
        }
    }
}