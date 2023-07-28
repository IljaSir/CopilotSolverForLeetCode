class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.length();
        if(n <= 1) return "";
        unordered_map<char, int> mp;
        for(int i = 0; i < n; ++i) {
            mp[s[i]]++;
        }
        for(int i = 0; i < n; ++i) {
            if(mp[toupper(s[i])] && mp[tolower(s[i])]) continue;
            string left = longestNiceSubstring(s.substr(0, i));
            string right = longestNiceSubstring(s.substr(i+1, n));
            return left.length() > right.length() ? left : right;
        }
        return s;
    }
};