class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        
        int n = plantTime.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; ++i) {
            v.push_back({plantTime[i], growTime[i]});
        }
        sort(v.begin(), v.end());
        int day = 0;
        for (int i = 0; i < n; ++i) {
            day = max(day, v[i].first) + v[i].second;
        }
        return day;
    }
};