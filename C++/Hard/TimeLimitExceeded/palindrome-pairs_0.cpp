class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        vector<vector<int>> res;
        unordered_map<string, int> m;
        for (int i = 0; i < words.size(); ++i) {
            m[words[i]] = i;
        }
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j <= words[i].size(); ++j) {
                string s1 = words[i].substr(0, j);
                string s2 = words[i].substr(j);
                if (isPalindrome(s1)) {
                    string s2_rev = s2;
                    reverse(s2_rev.begin(), s2_rev.end());
                    if (m.count(s2_rev) && m[s2_rev] != i) {
                        res.push_back({m[s2_rev], i});
                    }
                }
                if (isPalindrome(s2)) {
                    string s1_rev = s1;
                    reverse(s1_rev.begin(), s1_rev.end());
                    if (m.count(s1_rev) && m[s1_rev] != i && s2.size() != 0) {
                        res.push_back({i, m[s1_rev]});
                    }
                }
            }
        }
        return res;
    }
    
    bool isPalindrome(string s) {
        int i = 0, j = s.size() - 1;
        while (i < j) {
            if (s[i++] != s[j--]) return false;
        }
        return true;
    }
};