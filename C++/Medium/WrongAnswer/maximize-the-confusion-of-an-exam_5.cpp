class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int res = 0;
        for (int i = 0; i < 2; i++) {
            int l = 0, r = 0;
            int cnt = 0;
            while (r < n) {
                if (answerKey[r] == 'T' + i) {
                    cnt++;
                }
                r++;
                if (r - l > cnt + k) {
                    if (answerKey[l] == 'T' + i) {
                        cnt--;
                    }
                    l++;
                }
                res = max(res, r - l);
            }
        }
        return res;
    }
};