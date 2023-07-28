class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        vector<pair<int,int>> v;
        for(int i=0;i<indices.size();i++){
            v.push_back({indices[i],i});
        }
        sort(v.begin(),v.end());
        for(int i=v.size()-1;i>=0;i--){
            int index=v[i].first;
            int id=v[i].second;
            string source=sources[id];
            string target=targets[id];
            if(s.substr(index,source.size())==source){
                s=s.substr(0,index)+target+s.substr(index+source.size());
            }
        }
        return s;
    }
};