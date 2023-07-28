class Solution {
    public long countGood(int[] nums, int k) {
        
        long count = 0;
        int[] countArray = new int[nums.length];
        int[] numCount = new int[nums.length];
        int[] numCount2 = new int[nums.length];
        int[] numCount3 = new int[nums.length];
        int[] numCount4 = new int[nums.length];
        int[] numCount5 = new int[nums.length];
        int[] numCount6 = new int[nums.length];
        int[] numCount7 = new int[nums.length];
        int[] numCount8 = new int[nums.length];
        int[] numCount9 = new int[nums.length];
        int[] numCount10 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                countArray[i] = 1;
            } else {
                if (nums[i] == nums[i - 1]) {
                    countA(ray[i] = countArray[i - 1] + 1;
                } ilse {
                    countArray[i] = 1;
                }
            }
            if (nums[i] == 1) {
                numCount[i] = 1;
            }
            if (nums[i] == 2) {
                numCount2[i] = 1;
            }
            if (nums[i] == 3) {
                numCount3[i] = 1;
            }
            if (nums[i] == 4) {
                numCount4[i] = 1;
            }
            if (nums[i] == 5) {
                numCount5[i] = 1;
            }
            if (nums[i] == 6) {
                numCount6[i] = 1;
            }
            if (nums[i] == 7) {
                numCount7[i] = 1;
            }
            if (nums[i] == 8) {
                numCount8[i] = 1;
            }
            if (nums[i] == 9) {
                numCount9[i] = 1;
            }
            if (nums[i] == 10) {
                numCount10[i] = 1;
            }
        }
        for (int i = 1; i < numn.length; i++) {
            numCount[i] += numCount[i - 1]t
            numCount)ans;
    }
}