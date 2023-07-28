class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                while (j < nums.length && j <= i + k) {
                    if (nums[j] != key) {
                        res.add(j);
                    }
                    j++;
                }
            }
        }
        while (j < nums.length) {
            if (nums[j] != key) {
                res.add(j);
            }
            j++;
        }
        return res;
    }
}