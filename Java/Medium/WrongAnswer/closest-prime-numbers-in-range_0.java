class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] res = {-1, -1};
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (res[0] == -1) {
                    res[0] = i;
                } else {
                    res[1] = i;
                    break;
                }
            }
        }
        if (res[1] == -1) {
            return res;
        }
        int l = res[0], r = res[1];
        for (int i = right; i >= left; i--) {
            if (isPrime(i)) {
                if (res[1] == -1) {
                    res[1] = i;
                } else {
                    res[0] = i;
                    break;
                }
            }
        }
        if (Math.abs(res[1] - res[0]) > Math.abs(r - l)) {
            return new int[] {l, r};
        }
        return res;
    }
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}