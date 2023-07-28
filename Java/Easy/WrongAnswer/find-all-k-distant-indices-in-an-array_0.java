class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < nums.length && nums[j] == key) {
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }
}