class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        
        int n = plantTime.size();
        vector<pair<int,int>> v;
        for(int i=0;i<n;i++){
            v.push_back({plantTime[i],growTime[i]});
        }
        sort(v.begin(),v.end());
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = max(ans + v[i].first, v[i].second);
        }
        return ans;
    }
};