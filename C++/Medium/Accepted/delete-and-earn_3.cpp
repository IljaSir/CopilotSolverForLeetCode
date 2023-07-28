class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int maxVal = *max_element(nums.begin(), nums.end());
        vector<int> sum(maxVal + 1);
        for (int x: nums) sum[x] += x;
        return rob(sum);
    }
    int rob(vector<int>& nums) {
        int pre = 0, cur = 0;
        for (int i = 0; i < nums.size(); i++) {
            int temp = cur;
            cur = max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }
};