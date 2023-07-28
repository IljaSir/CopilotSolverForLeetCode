class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] = target[i] - nums[i];
        }
        Arrays.sort(diff);
        int i = 0, j = diff.length - 1;
        long count = 0;
        while (i < j) {
            if (diff[i] + diff[j] == 0) {
                count++;
                i++;
                j--;
            } else if (diff[i] + diff[j] < 0) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
    
    public int minOperations(int[] nums, int[] target) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long targetSum = 0;
        for (int num : target) {
            targetSum += num;
        }
        long diff = targetSum - sum;
        if (diff % 2 != 0) {
            return -1;
        }
        long half = diff / 2;
        long similar = makeSimilar(nums, target);
        if (Math.abs(half) > similar) {
            return -1;
        }
        return (int) (similar - Math.abs(half));
    }
}