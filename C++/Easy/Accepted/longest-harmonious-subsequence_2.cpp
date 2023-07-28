class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            m[nums[i]]++;
            if (m.find(nums[i] + 1) != m.end()) {
                res = max(res, m[nums[i]] + m[nums[i] + 1]);
            }
            if (m.find(nums[i] - 1) != m.end()) {
                res = max(res, m[nums[i]] + m[nums[i] - 1]);
            }
        }
        return res;
    }
};