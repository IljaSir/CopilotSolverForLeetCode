class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        
        vector<vector<int>> res;
        unordered_map<string, int> mp;
        for (int i = 0; i < words.size(); ++i) {
            mp[words[i]] = i;
        }
        if (mp.count("")) {
            int blank = mp[""];
            for (int i = 0; i < words.size(); ++i) {
                if (i == blank) continue;
                if (isPalindrome(words[i])) {
                    res.push_back({blank, i});
                    res.push_back({i, blank});
                }
            }
        }
        for (int i = 0; i < words.size(); ++i) {
            string t = words[i];
            reverse(t.begin(), t.end());
            if (mp.count(t) && mp[t] != i) {
                res.push_back({i, mp[t]});
            }
        }
        for (int i = 0; i < words.size(); ++i) {
            string t = words[i];
            for (int j = 0; j < t.size(); ++j) {
                string left = t.substr(0, j);
                string right = t.substr(j);
                if (isPalindrome(left)) {
                    string r = right;
                    reverse(r.begin(), r.end());
                    if (mp.count(r) && mp[r] != i) {
                        res.push_back({mp[r], i});
                    }
                }
                if (isPalindrome(right)) {
                    string l = left;
                    reverse(l.begin(), l.end());
                    if (mp.count(l) && mp[l] != i) {
                        res.push_back({i, mp[l]});
                    }
                }
            }
        }
        return res;
    }
    
    bool isPalindrome(string& s) {
        int i = 0;
        int j = s.size() - 1;
        while (i < j) {
            if (s[i] != s[j]) return false;
            ++i;
            --j;
        }
        return true;
    }
};