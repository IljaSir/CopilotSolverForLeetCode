class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            return p[x] == x ? x : p[x] = find(p[x]);
        };
        for (auto& pair: pairs) {
            p[find(pair[0])] = find(pair[1]);
        }
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < n; ++i) {
            mp[find(i)].push_back(i);
        }
        for (auto& [_, idx]: mp) {
            string t;
            for (int i: idx) {
                t += s[i];
            }
            sort(t.begin(), t.end());
            sort(idx.begin(), idx.end());
            for (int i = 0; i < idx.size(); ++i) {
                s[idx[i]] = t[i];
            }
        }
        return s;
    }
};