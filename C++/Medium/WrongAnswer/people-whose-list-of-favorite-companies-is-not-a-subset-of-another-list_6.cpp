class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> res;
        int n = favoriteCompanies.size();
        vector<set<string>> companies(n);
        for (int i = 0; i < n; ++i) {
            for (auto& company : favoriteCompanies[i]) {
                companies[i].insert(company);
            }
        }
        for (int i = 0; i < n; ++i) {
            bool isSubset = false;
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (companies[j].size() > companies[i].size()) continue;
                bool isSubsetOfJ = true;
                for (auto& company : companies[i]) {
                    if (companies[j].find(company) == companies[j].end()) {
                        isSubsetOfJ = false;
                        break;
                    }
                }
                if (isSubsetOfJ) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) res.push_back(i);
        }
        return res;
    }
};