class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                result.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < result.size(); j++) {
                if (Math.abs(result.get(j) - i) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}