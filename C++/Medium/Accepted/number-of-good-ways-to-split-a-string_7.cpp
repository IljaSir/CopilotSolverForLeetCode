class Solution {
public:
    int numSplits(string s) {
        
        int n = s.size();
        int left[26] = {0}, right[26] = {0};
        for (char c : s) right[c - 'a']++;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            left[s[i] - 'a']++;
            right[s[i] - 'a']--;
            int leftcnt = 0, rightcnt = 0;
            for (int j = 0; j < 26; ++j) {
                if (left[j] > 0) leftcnt++;
                if (right[j] > 0) rightcnt++;
            }
            if (leftcnt == rightcnt) res++;
        }
        return res;
    }
};