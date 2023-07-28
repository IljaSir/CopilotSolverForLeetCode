class Solution {
public:
    long long minimumMoney(vector<vector<int>>& transactions) {
        
        vector<pair<int,int>> v;
        for(auto& t:transactions){
            v.emplace_back(t[0],t[1]);
        }
        sort(v.begin(),v.end());
        long long ans=0;
        for(auto& t:v){
            ans+=t.first;
            ans=max(ans,(long long)t.first+t.second);
        }
        return ans;
    }
};