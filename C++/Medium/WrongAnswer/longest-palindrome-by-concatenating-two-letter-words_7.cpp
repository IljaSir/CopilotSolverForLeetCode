class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        unordered_map<string, int> m;
        for (auto word : words) {
            string s = word;
            reverse(s.begin(), s.end());
            if (m.count(s)) {
                m[s]++;
            } else {
                m[word]++;
            }
        }
        int ans = 0;
        string mid;
        for (auto p : m) {
            if (p.first == string(p.first.rbegin(), p.first.rend())) {
                if (p.second % 2 == 1) {
                    mid = p.first;
                }
                ans += p.second / 2 * 2;
            } else if (m.count(p.first)) {
                int n = min(m[p.first], m[p.first]);
                ans += n / 2 * 2;
                m[p.first] -= n;
                m[p.first] -= n;
            }
        }
        return ans + mid.size();
    }
};