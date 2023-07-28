class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        
        vector<int> res;
        int n = nums.size();
        vector<int> cnt(n+1, 0);
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 2) {
                res.push_back(i);
            } else if (cnt[i] == 0) {
                res.push_back(i);
            }
        }
        return res;
    }
};