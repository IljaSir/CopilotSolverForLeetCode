class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        int n = values.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; ++i) {
            v.emplace_back(values[i], labels[i]);
        }
        sort(v.begin(), v.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first > b.first;
        });
        unordered_map<int, int> cnt;
        int res = 0;
        for (int i = 0; i < n && numWanted > 0; ++i) {
            if (++cnt[v[i].second] <= useLimit) {
                res += v[i].first;
                --numWanted;
            }
        }
        return res;
    }
};