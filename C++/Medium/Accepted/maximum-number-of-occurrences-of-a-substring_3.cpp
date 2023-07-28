class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.size();
        unordered_map<string, int> m;
        for (int i = 0; i + minSize <= n; i++) {
            string t = s.substr(i, minSize);
            if (set<char>(t.begin(), t.end()).size() <= maxLetters) {
                m[t]++;
            }
        }
        int ans = 0;
        for (auto [k, v]: m) {
            ans = max(ans, v);
        }
        return ans;
    }
};