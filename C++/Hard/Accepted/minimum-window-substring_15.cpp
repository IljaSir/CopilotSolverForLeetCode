class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        if (n < m) return "";
        int i = 0;
        int j = 0;
        int count = 0;
        int minLen = INT_MAX;
        int minStart = -1;
        unordered_map<char, int> mp;
        for (char c : t) {
            mp[c]++;
        }
        while (j < n) {
            if (mp.find(s[j]) != mp.end()) {
                mp[s[j]]--;
                if (mp[s[j]] >= 0) {
                    count++;
                }
            }
            while (count == m) {
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    minStart = i;
                }
                if (mp.find(s[i]) != mp.end()) {
                    mp[s[i]]++;
                    if (mp[s[i]] > 0) {
                        count--;
                    }
                }
                i++;
            }
            j++;
        }
        if (minStart == -1) return "";
        return s.substr(minStart, minLen);
    }
};