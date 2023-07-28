class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        vector<pair<int, int>> v;
        for (int i = 0; i < values.size(); ++i) {
            v.push_back({values[i], labels[i]});
        }
        sort(v.begin(), v.end(), [](auto& a, auto& b) {
            return a.first > b.first;
        });
        int ans = 0;
        int num = 0;
        unordered_map<int, int> cnt;
        for (auto& p : v) {
            if (num == numWanted) {
                break;
            }
            if (cnt[p.second] < useLimit) {
                ans += p.first;
                ++cnt[p.second];
                ++num;
            }
        }
        return ans;
    }
};