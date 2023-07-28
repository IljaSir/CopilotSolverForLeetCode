class Solution {
    public int primePalindrome(int n) {
        
        int[] arr = {2, 3, 5, 7};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= n) {
                return arr[i];
            }
        }
        if (n <= 11) {
            return 11;
        }
        int base = 1;
        int res = 0;
        while (base <= n / 10) {
            base *= 10;
        }
        while (true) {
            res = buildPalindrome(base);
            if (res >= n && isPrime(res)) {
                return res;
            }
            base++;
        }
    }

    private int buildPalindrome(int base) {
        int res = base;
        while (base > 0) {
            res = res * 10 + base % 10;
            base /= 10;
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
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