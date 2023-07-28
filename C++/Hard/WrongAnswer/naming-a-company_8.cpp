class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        int n = ideas.size();
        unordered_map<string, int> m;
        for (auto& x : ideas) m[x] = 1;
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                string a = ideas[i], b = ideas[j];
                swap(a[0], b[0]);
                if (m[a] == 0 && m[b] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
};