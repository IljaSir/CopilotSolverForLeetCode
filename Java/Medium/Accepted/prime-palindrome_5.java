class Solution {
    public int primePalindrome(int n) {
        
        int i = n;
        while (true) {
            if (isPalindrome(i) && isPrime(i)) {
                return i;
            }
            i++;
            if (i > 10000000 && i < 100000000) {
                i = 100000000;
            }
        }
    }
    
    private boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}