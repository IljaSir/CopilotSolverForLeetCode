class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long res = 0;
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] = nums[i] - target[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] < 0) {
                res += -diff[i];
            } else {
                res -= diff[i];
            }
        }
        if (res % 2 == 0) {
            return res / 2;
        } else {
            return -1;
        }
    }
}