class Solution {
    public String nearestPalindromic(String n) {
        
        int len = n.length();
        boolean even = len % 2 == 0;
        long num = Long.parseLong(n);
        long num2 = Long.parseLong(n.substring(0, len / 2));
        long num3 = (long)Math.pow(10, len - 1);
        long num4 = (long)Math.pow(10, len) + 1;
        long num5 = (long)Math.pow(10, len - 1) - 1;
        long[] nums = new long[]{num2 - 1, num2, num2 + 1};
        long min = Long.MAX_VALUE;
        long res = 0;
        for (int i = 0; i < 3; i++) {
            long num6 = nums[i];
            long num7 = Long.parseLong(new StringBuilder(String.valueOf(num6)).reverse().toString());
            if (even) {
                num6 = Long.parseLong(String.valueOf(num6) + num7);
            } else {
                num6 = Long.parseLong(String.valueOf(num6) + num7 / 10);
            }
            if (num6 == num) {
                continue;
            }
            if (Math.abs(num6 - num) < min) {
                min = Math.abs(num6 - num);
                res = num6;
            } else if (Math.abs(num6 - num) == min) {
                res = Math.min(res, num6);
            }
        }
        if (Math.abs(num3 - num) < min) {
            min = Math.abs(num3 - num);
            res = num3;
        } else if (Math.abs(num3 - num) == min) {
            res = Math.min(res, num3);
        }
        if (Math.abs(num4 - num) < min) {
            min = Math.abs(num4 - num);
            res = num4;
        } else if (Math.abs(num4 - num) == min) {
            res = Math.min(res, num4);
        }
        if (Math.abs(num5 - num) < min) {
            min = Math.abs(num5 - num);
            res = num5;
        } else if (Math.abs(num5 - num) == min) {
            res = Math.min(res, num5);
        }
        return String.valueOf(res);
    }
}