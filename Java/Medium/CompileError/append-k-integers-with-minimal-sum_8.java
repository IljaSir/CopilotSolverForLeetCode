class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        Arrays.sort(nums);
        long sum = 0;
        int i = 0;
        while (i < nums.length) {
            if (i == 0 && nums[i] != 1) {
                long count = Math.min(k, nums[i] - 1);
                sum += count * (count + 1) / 2;
                k -= count;
            } else if (i > 0 && nums[i] - nums[i - 1] > 1) {
                long count = Math.min(k, nums[i] - nums[i - 1] - 1);
                sum += (nums[i - 1] + 1L) * count + count * (count + 1) / 2;
                k -= count;
            }
            if (k == 0) {
                break;
            }
            i++;
        }
        return sum + k * (nums[nums.length - 1] + 1L);
    }
}
    }
}