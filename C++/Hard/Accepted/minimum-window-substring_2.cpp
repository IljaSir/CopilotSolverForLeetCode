class Solution {
public:
    string minWindow(string s, string t) {
        
        vector<int> count(128, 0);
        for (char c : t) {
            count[c]++;
        }
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLen = INT_MAX;
        int countT = t.size();
        while (right < s.size()) {
            if (count[s[right++]]-- > 0) {
                countT--;
            }
            while (countT == 0) {
                if (right - left < minLen) {
                    minLeft = left;
                    minLen = right - left;
                }
                if (count[s[left++]]++ == 0) {
                    countT++;
                }
            }
        }
        return minLen == INT_MAX ? "" : s.substr(minLeft, minLen);
    }
};