class Solution {
    public long[] sumOfThree(long num) {
        
        long [] result = new long[3];
        if (num < 3) {
            return new long[0];
        }
        long sum = 0;
        long start = num / 3;
        long end = num / 3 + 3;
        long mid = (start + end) / 2;
        while (start <= end) {
            sum = mid * (mid + 1) * (mid + 2) / 6;
            if (sum == num) {
                result[0] = mid;
                result[1] = mid + 1;
                result[2] = mid + 2;
                return result;
            } else if (sum > num) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        return new long[0];
    }
}