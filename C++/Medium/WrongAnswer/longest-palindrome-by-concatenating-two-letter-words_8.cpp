class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int n = words.size();
        unordered_map<string, int> m;
        for (auto word : words) {
            string s = word;
            reverse(s.begin(), s.end());
            if (s == word) {
                m[s] = max(m[s], 1);
            } else {
                m[s] = max(m[s], 0);
            }
        }
        int res = 0;
        for (auto it : m) {
            if (m.count(it.first) && m[it.first] == 0) {
                res += it.first.length();
                m[it.first] = 1;
            }
        }
        for (auto it : m) {
            if (m[it.first] == 1) {
                res += it.first.length();
                break;
            }
        }
        return res;
    }
};