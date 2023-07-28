class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> res;
        unordered_map<string, int> m;
        int n = favoriteCompanies.size();
        vector<bitset<100>> b(n);
        for (int i = 0; i < n; ++i) {
            for (auto& s : favoriteCompanies[i]) {
                if (!m.count(s)) m[s] = m.size();
                b[i].set(m[s]);
            }
        }
        for (int i = 0; i < n; ++i) {
            bool flag = true;
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if ((b[i] & b[j]) == b[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(i);
        }
        return res;
    }
};