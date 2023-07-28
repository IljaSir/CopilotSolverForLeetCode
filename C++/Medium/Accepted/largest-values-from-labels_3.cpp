class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        int n = values.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; i++) {
            v.push_back({values[i], labels[i]});
        }
        sort(v.begin(), v.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first > b.first;
        });
        unordered_map<int, int> m;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (numWanted == 0) {
                break;
            }
            if (m[v[i].second] < useLimit) {
                ans += v[i].first;
                m[v[i].second]++;
                numWanted--;
            }
        }
        return ans;
    }
};