class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int l = 0, r = 0;
        int res = 0;
        int cnt = 0;
        while (r < n) {
            if (answerKey[r] == 'F') {
                cnt++;
            }
            if (cnt > k) {
                if (answerKey[l] == 'F') {
                    cnt--;
                }
                l++;
            }
            res = max(res, r - l + 1);
            r++;
        }
        l = 0, r = 0;
        cnt = 0;
        while (r < n) {
            if (answerKey[r] == 'T') {
                cnt++;
            }
            if (cnt > k) {
                if (answerKey[l] == 'T') {
                    cnt--;
                }
                l++;
            }
            res = max(res, r - l + 1);
            r++;
        }
        return res;
    }
};