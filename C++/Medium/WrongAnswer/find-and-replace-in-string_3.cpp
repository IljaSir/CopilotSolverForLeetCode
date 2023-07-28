class Solution {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        
        int n = indices.size();
        vector<int> order(n);
        iota(order.begin(), order.end(), 0);
        sort(order.begin(), order.end(), [&](int a, int b) { return indices[a] < indices[b]; });
        string ans;
        int i = 0;
        for (int j = 0; j < n; ++j) {
            int k = order[j];
            int idx = indices[k];
            ans += s.substr(i, idx - i);
            if (s.substr(idx, sources[k].size()) == sources[k]) {
                ans += targets[k];
                i = idx + sources[k].size();
            }
        }
        ans += s.substr(i);
        return ans;
    }
};