class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int n = s.size();
        if (n <= 1) return s;
        vector<int> cnt(26, 0);
        for (int i = 0; i < n; ++i) {
            cnt[s[i] - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] < s[pos]) pos = i;
            if (--cnt[s[i] - 'a'] == 0) break;
        }
        string ans;
        ans += s[pos];
        string tmp = s.substr(pos + 1);
        tmp.erase(remove(tmp.begin(), tmp.end(), s[pos]), tmp.end());
        ans += removeDuplicateLetters(tmp);
        return ans;
    }
};