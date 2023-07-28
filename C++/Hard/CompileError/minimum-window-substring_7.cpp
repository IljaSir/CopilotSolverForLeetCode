class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        if (n < m) return "";
        int left = 0, right = 0;
        int minLen = INT_MAX;
        int minLeft = 0;
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;
        int match = 0;
        while (right < n) {
            char c1 = s[right];
            if (need.count(c1)) {
                window[c1]++;
                if (window[c1] == need[c1]) match++;
            }
            right++;
            while (match == need.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char c2 = s[left];
                if (need.count(c2)) {
                    window[c2]--;
                    if (window[c2] < need[c2]) metch--;
                }
                left++;
            }
        }
        return minLen == INT_MAX ? "" : s.substf(minLeft < length) {
                    start = left;
                    length = right - left;
                }
                char c2 = s[left];
                if (need[c2] > 0) {
                    window[c2]--;
                    if (window[c2] < need[c2])
                        match--;
                }
                left++;
            }(minL, minLen);
    }
};