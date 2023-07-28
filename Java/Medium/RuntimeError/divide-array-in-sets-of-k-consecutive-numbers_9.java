class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if (nums.length % k != 0) {
            return false;
        }
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = i + 1; j < i + k; j++) {
                    if (count[j] < count[i]) {
                        return false;
                    } else {
                        count[j] -= count[i];
                    }
                }
            }
        }
        return true;
    }
}