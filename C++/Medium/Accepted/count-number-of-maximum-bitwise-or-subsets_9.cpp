class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int, int> mp;
        mp[0] = 1;
        for (auto x : nums) {
            auto tmp = mp;
            for (auto& [k, v] : tmp) {
                mp[k | x] += v;
            }
        }
        int max = 0;
        for (auto& [k, v] : mp) {
            if (k > max) {
                max = k;
            }
        }
        return mp[max];
    }
};