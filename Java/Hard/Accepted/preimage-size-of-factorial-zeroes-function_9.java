class Solution {
    public int preimageSizeFZF(int k) {
        
        long start = 1;
        long end = Long.MAX_VALUE;
        long mid;
        long count;
        while (start <= end) {
            mid = (start + end) / 2;
            count = count(mid);
            if (count == k) {
                return 5;
            } else if (count < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
    
    private long count(long x) {
        long count = 0;
        while (x > 0) {
            count += x / 5;
            x /= 5;
        }
        return count;
    }
}