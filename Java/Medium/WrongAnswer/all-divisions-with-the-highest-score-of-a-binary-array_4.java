class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            count[nums[i]]--;
            int cur = count[0] + count[1];
            if (cur > max) {
                max = cur;
                res.clear();
                res.add(i);
            } else if (cur == max) {
                res.add(i);
            }
            count[nums[i]]++;
        }
        return res;
    }
}