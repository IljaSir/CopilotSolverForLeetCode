class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        int ans = 0;
        unordered_map<int, int> mp;
        for (auto& x: nums) mp[x]++;
        for (auto& x: mp) {
            auto it = mp.find(x.first + 1);
            if (it != mp.end()) ans = max(ans, x.second + it->second);
        }
        return ans;
    }
};