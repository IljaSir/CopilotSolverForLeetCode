class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // 1. sort
        // Arrays.sort(nums);
        // 2. hashset
        // HashSet<Integer> hashSet = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     hashSet.add(nums[i]);
        // }
        // List<Integer> result = new ArrayList<>();
        // for (int i = 1; i <= nums.length; i++) {
        //     if (!hashSet.contains(i)) {
        //         result.add(i);
        //     }
        // }
        // return result;
        // 3. mark
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}