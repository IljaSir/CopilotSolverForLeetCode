class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int n = strs.size();
        sort(strs.begin(), strs.end(), [](string& s1, string& s2) {
            return s1.size() > s2.size();
        });
        unordered_map<string, int> m;
        for (int i = 0; i < n; i++) {
            m[strs[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (m[strs[i]] == 1) {
                int j = 0;
                for (j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (isSubsequence(strs[i], strs[j])) break;
                }
                if (j == n) return strs[i].size();
            }
        }
        return -1;
    }
    bool isSubsequence(string& s, string& t) {
        int i = 0, j = 0;
        while (i < s.size() && j < t.size()) {
            if (s[i] == t[j]) i++;
            j++;
        }
        return i == s.size();
    }
};