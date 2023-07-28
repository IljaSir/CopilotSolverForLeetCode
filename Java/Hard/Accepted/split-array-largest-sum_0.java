class Solution {
    public int splitArray(int[] nums, int k) {
        
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (k == 1) return (int) sum;
        long l = max, r = sum;
        while (l < r) {
            long mid = (l + r) / 2;
            if (valid(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean valid(int[] nums, long target, int k) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > k) return false;
            }
        }
        return true;
    }
}