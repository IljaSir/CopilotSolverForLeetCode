class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] powers = new int[hi - lo + 1];
        int[] nums = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            nums[i - lo] = i;
            powers[i - lo] = power(i);
        }
        for (int i = 0; i < powers.length; i++) {
            for (int j = i + 1; j < powers.length; j++) {
                if (powers[i] > powers[j]) {
                    int tmp = powers[i];
                    powers[i] = powers[j];
                    powers[j] = tmp;
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                } else if (powers[i] == powers[j]) {
                    if (nums[i] > nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
        return nums[k - 1];
    }
    private int power(int x) {
        int p = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            p++;
        }
        return p;
    }
}