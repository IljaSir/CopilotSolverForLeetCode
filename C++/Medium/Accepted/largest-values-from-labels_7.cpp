class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        vector<pair<int,int>> v;
        int n = values.size();
        for(int i = 0; i < n; i++){
            v.push_back({values[i],labels[i]});
        }
        sort(v.begin(),v.end());
        reverse(v.begin(),v.end());
        map<int,int> m;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(numWanted == 0) break;
            if(m[v[i].second] < useLimit){
                m[v[i].second]++;
                ans += v[i].first;
                numWanted--;
            }
        }
        return ans;
    }
};