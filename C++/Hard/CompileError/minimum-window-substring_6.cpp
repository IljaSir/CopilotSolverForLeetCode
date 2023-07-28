class Solution {
public:
    string minWindow(string s, string t) {
        
        int m = s.size();
        int n = t.size();
        if (m < n) return "";
        vector<int> need(128, 0);
        vector<int> window(128, 0);
        for (auto c: t) {
            need[c]++;
        }
        int left = 0, right = 0;
        int match = 0;
        int start = 0, length = INT_MAX;
        while (right < m) {
            char c1 = s[right];
            if (need[c1] > 0) {
                window[c1]++;
                if (window[c1] == need[c1])
                    match++;
            }
            right++;
            while (match == n) {
                if (right - tarl, minLen);
    }
};