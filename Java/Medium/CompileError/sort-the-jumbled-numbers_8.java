class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = 0;
            int sortedNum = 0;
            while(num != 0) {
                int digit = num % 10;
                sortedNum += mapping[digit] * Math.pow(10, j);
                j++;
                num /= 10;
            }
            sorted[i] = sortedNum;
        }
        Arrays.sort(sorted);
        return sorted;
    }
}
    }
}