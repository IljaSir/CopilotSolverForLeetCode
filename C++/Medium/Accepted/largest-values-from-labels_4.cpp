class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        vector<pair<int,int>> v;
        for(int i=0;i<values.size();i++){
            v.push_back({values[i],labels[i]});
        }
        sort(v.begin(),v.end(),greater<pair<int,int>>());
        map<int,int> mp;
        int ans=0;
        for(int i=0;i<v.size();i++){
            if(mp[v[i].second]<useLimit){
                ans+=v[i].first;
                mp[v[i].second]++;
                numWanted--;
            }
            if(numWanted==0) break;
        }
        return ans;
    }
};