class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> result;
        for(int i=0; i<favoriteCompanies.size(); i++){
            bool isSubset = false;
            for(int j=0; j<favoriteCompanies.size(); j++){
                if(i==j) continue;
                if(isSubsetOf(favoriteCompanies[i], favoriteCompanies[j])){
                    isSubset = true;
                    break;
                }
            }
            if(!isSubset) result.push_back(i);
        }
        return result;
    }
    
    bool isSubsetOf(vector<string>& v1, vector<string>& v2){
        for(int i=0; i<v1.size(); i++){
            bool found = false;
            for(int j=0; j<v2.size(); j++){
                if(v1[i]==v2[j]){
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;
    }
};