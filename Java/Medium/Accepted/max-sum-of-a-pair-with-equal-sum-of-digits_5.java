class Solution {
    public int maximumSum(int[] nums) {
        
        int[] count = new int[100];
        Arrays.fill(count, -1);
        int res = -1;
        for (int num: nums) {
            int sum = getSum(num);
            if (count[sum] != -1) {
                res = Math.max(res, count[sum] + num);
            }
            count[sum] = Math.max(count[sum], num);
        }
        return res;
    }
    
    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}