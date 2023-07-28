class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> res;
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            bool isSubset = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) continue;
                if (isSubsetOf(favoriteCompanies[i], favoriteCompanies[j])) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) res.push_back(i);
        }
        return res;
    }
};