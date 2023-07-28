class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        vector<int> ans(2, 0);
        unordered_map<int, int> mp;
        for (int n : nums) {
            mp[n]++;
        }
        for (auto it : mp) {
            int count = it.second;
            ans[0] += count / 2;
            ans[1] += count % 2;
        }
        return ans;
    }
};