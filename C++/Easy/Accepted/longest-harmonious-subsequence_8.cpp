class Solution {
public:
    int findLHS(vector<int>& nums) {
        
        int res = 0;
        unordered_map<int, int> m;
        for (int n: nums) {
            m[n]++;
        }
        for (auto &p: m) {
            if (m.count(p.first + 1)) {
                res = max(res, p.second + m[p.first + 1]);
            }
        }
        return res;
    }
};