class Solution {
    public long kMirror(int k, int n) {
        
        long[] nums = new long[n];
        int count = 0;
        long num = 1;
        while (count < n) {
            if (isMirror(num, k)) {
                nums[count++] = num;
            }
            num++;
        }
        long sum = 0;
        for (long num1 : nums) {
            sum += num1;
        }
        return sum;
    }
    private boolean isMirror(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        String str = sb.toString();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}