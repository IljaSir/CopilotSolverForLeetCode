class Solution {
    public String smallestGoodBase(String n) {
        
        long num = Long.parseLong(n);
        for (int i = 63; i >= 2; i--) {
            long l = 2;
            long r = (long) Math.pow(num, 1.0 / (i - 1)) + 1;
            while (l < r) {
                long mid = l + (r - l) / 2;
                long sum = 0;
                for (int j = 0; j < i; j++) {
                    sum = sum * mid + 1;
                }
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum > num) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }
}