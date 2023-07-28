class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        
        vector<int> ans;
        ans.resize(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            ans[i] = -1;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
};