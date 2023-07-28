class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int n = s.size();
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') cnt0++;
            else cnt1++;
            if (target[i] == '0') cnt0--;
            else cnt1--;
        }
        return cnt0 == 0 && cnt1 == 0;
    }
};