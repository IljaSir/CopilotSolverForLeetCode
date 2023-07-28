class Solution {
    public int primePalindrome(int n) {
        
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;
        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            String r = new StringBuilder(s).reverse().toString().substring(1);
            int x = Integer.parseInt(s + r);
            if (x >= n && isPrime(x)) return x;
        }
        return -1;
    }
    private boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        if (x < 9) return true;
        if (x % 3 == 0) return false;
        int r = (int) Math.sqrt(x);
        int f = 5;
        while (f <= r) {
            if (x % f == 0) return false;
            if (x % (f + 2) == 0) return false;
            f += 6;
        }
        return true;
    }
}