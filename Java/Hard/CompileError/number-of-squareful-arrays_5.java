class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int[] count = new int[1];
        Arrays.sort(nums);
        permute(nums, 0, count);
        return count[0];
    }
    private void permute(int[] nums, int index, int[] count) {
        if (index == nums.length) {
            count[0]++;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            if (index != 0 && !isSquare(nums[index - 1], nums[i])) continue;
            swap(nums, index, i);
            permute(nums, index + 1, count);
            swap(nums, index, i);
        }
    }
    private boolean isSquare(int a, int b) {
        int c = (int) Math.sqrt(a + b);
        return c * c == a + b;
    }
}