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
    
    bool isSubsetOf(vector<string> &a, vector<string> &b) {
        int count = 0;
        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < b.size(); ++j) {
                if (a[i] == b[j]) {
                    ++count;
                    break;
                }
            }
        }
        return count == a.size();
    }
};