class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        int n = s.size();
        int m = target.size();
        if (n < m) {
            return 0;
        }
        vector<int> cnts(26, 0);
        for (char c : s) {
            ++cnts[c - 'a'];
        }
        for (char c : target) {
            if (--cnts[c - 'a'] < 0) {
                return 0;
            }
        }
        int ans = 1;
        int maxCnt = 0;
        for (int cnt : cnts) {
            if (cnt > maxCnt) {
                maxCnt = cnt;
            }
        }
        int maxCntTarget = 0;
        for (char c : target) {
            if (c - 'a' == maxCnt) {
                ++maxCntTarget;
            }
        }
        int maxCntTargetCnt = 0;
        for (int cnt : cnts) {
            if (cnt == maxCnt) {
                ++maxCntTargetCnt;
            }
        }
        if (maxCntTargetCnt < maxCntTarget) {
            return 0;
        }
        if (m % maxCntTarget != 0) {
            return 0;
        }
        return m / maxCntTarget;
    }
};