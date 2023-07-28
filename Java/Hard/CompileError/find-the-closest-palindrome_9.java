class Solution {
    public String nearestPalindromic(String n) {
        
        int len = n.length();
        long num = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long minNum = 0;
        
        // 1. all 9s
        long all9s = (long) Math.pow(10, len) + 1;
        long diff = Math.abs(all9s - num);
        if (diff > 0 && diff < minDiff) {
            minDiff = diff;
            minNum = all9s;
        }
        
        // 2. all 0s
        long all0s = (long) Math.pow(10, len - 1) - 1;
        diff = Math.abs(all0s - num);
        if (diff > 0 && diff < minDiff) {
            minDiff = diff;
            minNum = all0s;
        }
        
        // 3. left half
        long leftHalf = Long.parseLong(n.substring(0, (len + 1) / 2));
        
        // 3.1. left half - 1
        long leftHalfMinus1 = leftHalf - 1;
        String leftHalfMinus1Str = Long.toString(leftHalfMinus1);
        String leftHalfMinus1StrRev = new StringBuilder(leftHalfMinus1Str).reverse().toString();
        String leftHalfMinus1StrFull = leftHalfMinus1Str + (len % 2 == 0 ? leftHalfMinus1StrRev : leftHalfMinus1StrRev.substring(1));
        long leftHalfMinus1Num = Long.parseLong(leftHalfMinus1StrFull);
        diff = Math.abs(leftHalfMinus1Num - num);
        if (diff > 0 && diff < minDiff) {
            minDiff = diff;
            minNum = leftHalfMinus1Num;
        }
        
        // 3.2. left half + 1
        long leftHalfPlus1 = leftHalf + 1;
        String leftHalfPlus1Str = Long.toString(leftHalfPlus1);
        String leftHalfPlus1StrRev = new StringBuilder(leftHalfPlus1Str).reverse().toString();
        String leftHalfPlus1StrFull = leftHalfPlus1Str + (len % 2 == 0 ? leftHalfPlus1StrRev : leftHalfPlus1StrRev.substring(1));
        long leftHalfPlus1Num = Long.parseLong(leftHalfPlus1StrFull);
    }
}