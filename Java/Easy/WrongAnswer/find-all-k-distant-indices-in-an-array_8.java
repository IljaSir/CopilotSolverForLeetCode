class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == key) {
                int j = i + 1;
                while (j < n && j - i <= k && nums[j] != key) j++;
                if (j - i > k) {
                    res.add(i);
                }
                i = j;
            } else {
                i++;
            }
        }
        return res;
    }
}