class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        
        int n = plantTime.size();
        vector<pair<int, int>> v(n);
        for (int i = 0; i < n; i++) {
            v[i] = {plantTime[i], growTime[i]};
        }
        sort(v.begin(), v.end());
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, v[i].first) + v[i].second;
        }
        return res;
    }
};