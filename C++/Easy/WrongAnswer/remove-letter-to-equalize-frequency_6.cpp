class Solution {
public:
    bool equalFrequency(string word) {
        
        int n = word.size();
        vector<int> cnt(26, 0);
        for (auto c : word) {
            cnt[c - 'a']++;
        }
        if (n == 2) {
            return true;
        }
        if (n == 3) {
            if (cnt[word[0] - 'a'] == 2) {
                return true;
            }
            if (cnt[word[1] - 'a'] == 2) {
                return true;
            }
            if (cnt[word[2] - 'a'] == 2) {
                return true;
            }
            return false;
        }
        int maxCnt = 0;
        int minCnt = n;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
            }
            if (cnt[i] > 0 && cnt[i] < minCnt) {
                minCnt = cnt[i];
            }
        }
        if (maxCnt == minCnt) {
            return true;
        }
        if (maxCnt - minCnt == 1) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == maxCnt) {
                    cnt1++;
                }
                if (cnt[i] == minCnt) {
                    cnt2++;
                }
            }
            if (cnt1 == 1) {
                return true;
            }
            if (cnt2 == 1) {
                return true;
            }
            return false;
        }
        return false;
    }
};