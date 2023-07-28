class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        vector<pair<int, int>> v;
        for (int i = 0; i < values.size(); i++) {
            v.push_back({values[i], labels[i]});
        }
        sort(v.begin(), v.end(), [](const auto& a, const auto& b) {
            return a.first > b.first;
        });
        unordered_map<int, int> m;
        int ans = 0;
        for (auto& p : v) {
            if (numWanted <= 0) break;
            if (m[p.second] < useLimit) {
                ans += p.first;
                m[p.second]++;
                numWanted--;
            }
        }
        return ans;
    }
};