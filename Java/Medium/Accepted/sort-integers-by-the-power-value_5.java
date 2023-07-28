class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] power = new int[hi - lo + 1];
        int[] nums = new int[hi - lo + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = lo + i;
        }
        for (int i = 0; i < power.length; i++) {
            power[i] = getPower(nums[i]);
        }
        for (int i = 0; i < power.length; i++) {
            for (int j = i + 1; j < power.length; j++) {
                if (power[i] > power[j]) {
                    int tmp = power[i];
                    power[i] = power[j];
                    power[j] = tmp;
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                } else if (power[i] == power[j]) {
                    if (nums[i] > nums[j]) {
                        int tmp = power[i];
                        power[i] = power[j];
                        power[j] = tmp;
                        tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
        return nums[k - 1];
    }

    private int getPower(int num) {
        int power = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = 3 * num + 1;
            }
            power++;
        }
        return power;
    }
}