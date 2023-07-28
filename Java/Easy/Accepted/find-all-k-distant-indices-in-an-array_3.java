class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                res.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (res.size() == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (res.get(0) - i > k) {
                continue;
            }
            if (res.get(res.size() - 1) - i < -k) {
                break;
            }
            for (int j = 0; j < res.size(); j++) {
                if (Math.abs(res.get(j) - i) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}