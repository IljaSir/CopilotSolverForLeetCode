class Solution {
    public int preimageSizeFZF(int k) {
        
        long left = 0;
        long right = 5L * (k + 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = trailingZeros(mid);
            if (count == k) {
                return 5;
            } else if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return 0;
    }
    
    private long trailingZeros(long x) {
        long res = 0;
        while (x > 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }
}