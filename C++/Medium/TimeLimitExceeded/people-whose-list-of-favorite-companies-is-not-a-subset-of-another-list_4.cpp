class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> res;
        for (int i = 0; i < favoriteCompanies.size(); ++i) {
            bool is_subset = false;
            for (int j = 0; j < favoriteCompanies.size(); ++j) {
                if (i == j) continue;
                if (isSubset(favoriteCompanies[i], favoriteCompanies[j])) {
                    is_subset = true;
                    break;
                }
            }
            if (!is_subset) res.push_back(i);
        }
        return res;
    }
    
    bool isSubset(vector<string>& a, vector<string>& b) {
        unordered_set<string> s;
        for (auto& word : b) s.insert(word);
        for (auto& word : a) {
            if (s.find(word) == s.end()) return false;
        }
        return true;
    }
};