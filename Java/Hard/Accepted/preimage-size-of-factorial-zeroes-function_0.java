class Solution {
    public int preimageSizeFZF(int k) {
        
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = trailingZeros(mid);
            if (count < k) {
                left = mid + 1;
            } else if (count > k) {
                right = mid;
            } else {
                return 5;
            }
        }
        return 0;
    }

    private long trailingZeros(long n) {
        long count = 0;
        long base = 5;
        while (n >= base) {
            count += n / base;
            base *= 5;
        }
        return count;
    }
}