class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        vector<vector<int>> ans;
        vector<int> v;
        int n = s.size();
        for(int i=0;i<n;i++){
            v.push_back(s[i]-'0');
        }
        for(int i=1;i<n;i++){
            v[i] = v[i]^v[i-1];
        }
        for(int i=0;i<queries.size();i++){
            int x = queries[i][0];
            int y = queries[i][1];
            if(x==0){
                ans.push_back({0,find(v.begin(),v.end(),y)-v.begin()});
            }
            else{
                ans.push_back({find(v.begin(),v.end(),x^y)-v.begin()+1,find(v.begin(),v.end(),y)-v.begin()});
            }
        }
        return ans;
    }
};