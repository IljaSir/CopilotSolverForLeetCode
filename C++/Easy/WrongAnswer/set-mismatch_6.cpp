class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(n+1, 0);
        vector<int> res;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 2) res.push_back(i);
            if (cnt[i] == 0) res.push_back(i);
        }
        return res;
    }
};