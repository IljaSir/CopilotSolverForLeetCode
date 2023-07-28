class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> ans;
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            bool isSubset = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) continue;
                if (isSubsetOf(favoriteCompanies[i], favoriteCompanies[j])) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) ans.push_back(i);
        }
        return ans;
    }
    
    bool isSubsetOf(vector<string>& a, vector<string>& b) {
        for (auto& s : a) {
            if (find(b.begin(), b.end(), s) == b.end()) return false;
        }
        return true;
    }
};