class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> result = new LinkedList<>();
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == key) {
                if (j - i <= k) {
                    result.add(i);
                }
                i++;
            }
            j++;
        }
        return result;
    }
}