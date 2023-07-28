class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int ans = 0;
        for (int n : nums) {
            m[n]++;
        }
        for (auto& [k, v] : m) {
            if (m.count(k + 1)) {
                ans = max(ans, v + m[k + 1]);
            }
        }
        return ans;
    }
};