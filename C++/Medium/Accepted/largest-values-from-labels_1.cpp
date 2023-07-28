class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        int n = values.size();
        vector<pair<int, int>> v(n);
        for (int i = 0; i < n; ++i) {
            v[i] = {values[i], labels[i]};
        }
        sort(v.begin(), v.end(), greater<pair<int, int>>());
        unordered_map<int, int> m;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (numWanted == 0) {
                break;
            }
            if (m[v[i].second] < useLimit) {
                ++m[v[i].second];
                result += v[i].first;
                --numWanted;
            }
        }
        return result;
    }
};