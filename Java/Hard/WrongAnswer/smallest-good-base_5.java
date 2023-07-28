class Solution {
    public String smallestGoodBase(String n) {
        
        long num = Long.valueOf(n);
        int max = (int) (Math.log(num) / Math.log(2));
        for (int i = max; i >= 2; i--) {
            long left = 2, right = (long) Math.pow(num, 1.0 / (i - 1)) + 1;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long sum = 0, cur = 1;
                for (int j = 0; j < i; j++) {
                    sum += cur;
                    cur *= mid;
                }
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return String.valueOf(num - 1);
    }
}