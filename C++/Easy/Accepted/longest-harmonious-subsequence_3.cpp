class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        map<int, int> m;
        for (auto& n : nums) {
            m[n]++;
        }
        int ans = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            auto it2 = it;
            it2++;
            if (it2 != m.end() && it->first + 1 == it2->first) {
                ans = max(ans, it->second + it2->second);
            }
        }
        return ans;
    }
};