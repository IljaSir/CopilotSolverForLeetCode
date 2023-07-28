class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        if (n < m) return "";

        vector<int> charCount(128, 0);
        for (auto c : t) charCount[c]++;

        int i = 0;
        int j = 0;
        int minLen = INT_MAX;
        int minStart = 0;
        int count = 0;
        while (j < n) {
            if (charCount[s[j++]]-- > 0) count++;
            while (count == m) {
                if (j - i < minLen) {
                    minLen = j - i;
                    minStart = i;
                }
                if (charCount[s[i++]]++ == 0) count--;
            }
        }
        return minLen == INT_MAX ? "" : s.substr(minStart, minLen);
    }
};