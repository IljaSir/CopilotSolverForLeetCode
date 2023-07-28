class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int[] minArr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i].length < minArr.length) {
                minArr = nums[i];
            }
        }
        for (int i = 0; i < minArr.length; i++) {
            int num = minArr[i];
            boolean isPresent = true;
            for (int j = 0; j < nums.length; j++) {
                if (!isPresent(num, nums[j])) {
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {
                result.add(num);
            }
        }
        return result;
    }
    
    private boolean isPresent(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return true;
        }
        return false;
    }
}