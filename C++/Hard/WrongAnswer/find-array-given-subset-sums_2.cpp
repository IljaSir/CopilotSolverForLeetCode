class Solution {
public:
    vector<int> recoverArray(int n, vector<int>& sums) {
        
        unordered_map<int, int> m;
        for (auto &s : sums) m[s]++;
        vector<int> ans;
        for (int i = 0; i < n; ++i) {
            int x = 0;
            for (auto &a : ans) x += a;
            for (auto &a : ans) m[x - a]--;
            for (auto &a : ans) m[x - a]++;
            for (auto &p : m) {
                if (p.second > 0) {
                    ans.push_back(p.first - x);
                    m[p.first]--;
                    break;
                }
            }
        }
        return ans;
    }
};