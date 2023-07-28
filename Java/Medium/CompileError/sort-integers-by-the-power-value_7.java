class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] power = new int[hi + 1];
        int[] nums = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            nums[i - lo] = i;
        }
        for (int i = 2; i <= hi; i++) {
            if (power[i] == 0) {
                int count = 0;
                int j = i;
                while (j != 1) {
                    if (j % 2 == 0) {
                        j /= 2;
                    } else {
                        j = 3 * j + 1;
                    }
                    count++;
                }
                power[i] = count;
            }
        }
        Arrays.sort(nums, (a, b) -> {
            if (power[a] == power[b]) {
                return a - b;
            } else {
                return power[a] - power[b];
            }
        });
        return nums[k - 1];
    }
}