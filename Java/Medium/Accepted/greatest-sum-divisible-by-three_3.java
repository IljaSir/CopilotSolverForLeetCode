class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int sum = 0;
        int min1 = 10001;
        int min2 = 10001;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                min2 = Math.min(min2, min1 + num);
                min1 = Math.min(min1, num);
            } else if (num % 3 == 2) {
                min1 = Math.min(min1, min2 + num);
                min2 = Math.min(min2, num);
            }
        }
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            return sum - min1;
        } else {
            return sum - min2;
        }
    }
}