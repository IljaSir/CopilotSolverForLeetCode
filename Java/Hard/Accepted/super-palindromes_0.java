class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int MAGIC = 100000;
        int ans = 0;

        // count odd length;
        for (int k = 1; k < MAGIC; ++k) {
            String s = Integer.toString(k);
            for (int i = s.length() - 2; i >= 0; --i)
                s += s.charAt(i);
            long v = Long.parseLong(s);
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v))
                ans++;
        }

        // count even length;
        for (int k = 1; k < MAGIC; ++k) {
            String s = Integer.toString(k);
            for (int i = s.length() - 1; i >= 0; --i)
                s += s.charAt(i);
            long v = Long.parseLong(s);
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v))
                ans++;
        }

        return ans;
    }

    public boolean isPalindrome(long x) {
        String s = Long.toString(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}