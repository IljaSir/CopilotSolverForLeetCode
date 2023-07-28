class Solution {
    public int findNthDigit(int n) {
        
        int i = 1;
        long sum = 0;
        while (true) {
            long tmp = 9 * (long) Math.pow(10, i - 1) * i;
            if (sum + tmp < n) {
                sum += tmp;
                i++;
            } else {
                break;
            }
        }
        int num = (int) (Math.pow(10, i - 1) + (n - sum - 1) / i);
        String s = String.valueOf(num);
        return s.charAt((n - sum - 1) % i) - '0';
    }
}