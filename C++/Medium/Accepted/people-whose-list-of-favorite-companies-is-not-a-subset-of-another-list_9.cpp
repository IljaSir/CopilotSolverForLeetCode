class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> res;
        vector<set<string>> setOfFavorites;
        for (auto& v: favoriteCompanies) {
            setOfFavorites.push_back(set<string>(v.begin(), v.end()));
        }
        for (int i = 0; i < setOfFavorites.size(); ++i) {
            bool isSubset = false;
            for (int j = 0; j < setOfFavorites.size(); ++j) {
                if (i == j) continue;
                if (includes(setOfFavorites[j].begin(), setOfFavorites[j].end(), setOfFavorites[i].begin(), setOfFavorites[i].end())) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) {
                res.push_back(i);
            }
        }
        return res;
    }
};