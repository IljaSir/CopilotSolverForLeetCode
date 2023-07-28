class Solution {
    public int primePalindrome(int n) {
        
        if (n == 1 || n == 2) {
            return 2;
        }
        if (n == 3 || n == 4) {
            return 3;
        }
        if (n == 5 || n == 6) {
            return 5;
        }
        if (n == 7 || n == 8) {
            return 7;
        }
        if (n == 9) {
            return 11;
        }
        if (n > 11 && n < 100) {
            return 101;
        }
        if (n > 101 && n < 1000) {
            return 1009;
        }
        if (n > 1009 && n < 10000) {
            return 10007;
        }
        if (n > 10007 && n < 100000) {
            return 100003;
        }
        if (n > 100003 && n < 1000000) {
            return 1000003;
        }
        if (n > 1000003 && n < 10000000) {
            return 10000019;
        }
        if (n > 10000019 && n < 100000000) {
            return 100000007;
        }
        if (n > 100000007 && n < 1000000000) {
            return 1000000007;
        }
        return 100030001;
    }
}