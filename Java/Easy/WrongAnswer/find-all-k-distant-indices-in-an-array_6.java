class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> result = new ArrayList<>();
        int prev = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                if (i - prev > k) {
                    result.add(i);
                }
                prev = i;
            }
        }
        return result;
    }
}