class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        vector<bool> ans;
        int n = nums.size();
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = ((num << 1) + nums[i]) % 5;
            ans.push_back(num == 0);
        }
        return ans;
    }
};