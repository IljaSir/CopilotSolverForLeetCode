class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i == 0) {
                if (num != nums[i + 1]) {
                    result.add(num);
                }
            } else if (i == nums.length - 1) {
                if (num != nums[i - 1]) {
                    result.add(num);
                }
            } else {
                if (num != nums[i - 1] && num != nums[i + 1]) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}