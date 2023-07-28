class Solution {
public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        
        vector<int> res;
        vector<set<string>> s;
        for(auto& v: favoriteCompanies){
            s.push_back(set<string>(v.begin(), v.end()));
        }
        for(int i = 0; i < s.size(); i++){
            bool flag = true;
            for(int j = 0; j < s.size(); j++){
                if(i == j) continue;
                if(includes(s[j].begin(), s[j].end(), s[i].begin(), s[i].end())){
                    flag = false;
                    break;
                }
            }
            if(flag) res.push_back(i);
        }
        return res;
    }
};