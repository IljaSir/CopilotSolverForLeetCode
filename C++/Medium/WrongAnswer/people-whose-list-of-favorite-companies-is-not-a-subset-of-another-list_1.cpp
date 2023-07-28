class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> result;
        for (int i = 0; i < favoriteCompanies.size(); ++i) {
            bool isSubset = false;
            for (int j = 0; j < favoriteCompanies.size(); ++j) {
                if (i == j) continue;
                if (isSubsetOf(favoriteCompanies[i], favoriteCompanies[j])) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) result.push_back(i);
        }
        return result;
    }
    
    bool isSubsetOf(vector<string>& a, vector<string>& b) {
        if (a.size() > b.size()) return false;
        unordered_set<string> set(a.begin(), a.end());
        for (auto& s : b) {
            if (set.count(s) == 0) return false;
        }
        return true;
    }
};