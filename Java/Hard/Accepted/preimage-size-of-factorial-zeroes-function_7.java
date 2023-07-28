class Solution {
    public int preimageSizeFZF(int k) {
        
        long left = 0, right = 5L * (k + 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = countZeros(mid);
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
    
    private long countZeros(long n) {
        long count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}