class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                mp[nums[i] * nums[j]]++;
            }
        }
        for (auto& [k, v] : mp) {
            res += v * (v - 1) / 2 * 8;
        }
        return res;
    }
};