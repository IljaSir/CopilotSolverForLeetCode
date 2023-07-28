class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int ans = 0;
        for (auto& p: cnt) {
            if (cnt.find(p.first + 1) != cnt.end()) {
                ans = max(ans, p.second + cnt[p.first + 1]);
            }
        }
        return ans;
    }
};