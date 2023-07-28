class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int l = 0, r = 0, n = answerKey.size();
        int cntT = 0, cntF = 0, res = 0;
        while (r < n) {
            cntT += answerKey[r] == 'T';
            cntF += answerKey[r] == 'F';
            while (r - l + 1 - cntT > k) {
                cntT -= answerKey[l] == 'T';
                l++;
            }
            while (r - l + 1 - cntF > k) {
                cntF -= answerKey[l] == 'F';
                l++;
            }
            res = max(res, r - l + 1);
            r++;
        }
        return res;
    }
};