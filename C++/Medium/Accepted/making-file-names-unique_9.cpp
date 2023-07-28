class Solution {
public:
    vector<string> getFolderNames(vector<string>& names) {
        
        vector<string> ans;
        unordered_map<string,int> mp;
        for(string& name:names){
            if(mp.find(name)==mp.end()){
                mp[name]=1;
                ans.push_back(name);
            }else{
                string tmp=name+"("+to_string(mp[name])+")";
                while(mp.find(tmp)!=mp.end()){
                    mp[name]++;
                    tmp=name+"("+to_string(mp[name])+")";
                }
                mp[name]++;
                mp[tmp]=1;
                ans.push_back(tmp);
            }
        }
        return ans;
    }
};