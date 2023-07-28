class Solution {
public:
    vector<string> invalidTransactions(vector<string>& transactions) {
        
        vector<string> ret;
        map<string,vector<vector<string>>> m;
        for(auto& t: transactions){
            istringstream is(t);
            vector<string> v;
            string s;
            while(getline(is, s, ',')){
                v.push_back(s);
            }
            m[v[0]].push_back(v);
        }
        for(auto& it: m){
            auto& v = it.second;
            for(int i = 0; i < v.size(); i++){
                bool flag = false;
                if(stoi(v[i][2]) > 1000){
                    flag = true;
                }else{
                    for(int j = 0; j < v.size(); j++){
                        if(i != j && v[i][3] != v[j][3] && abs(stoi(v[i][1]) - stoi(v[j][1])) <= 60){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag){
                    ret.push_back(v[i][0] + "," + v[i][1] + "," + v[i][2] + "," + v[i][3]);
                }
            }
        }
        return ret;
    }
};