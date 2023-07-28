class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int ans = 0;
        int l = 0, r = 0;
        int cntT = 0, cntF = 0;
        while (r < n) {
            if (answerKey[r] == 'T') {
                cntT++;
            } else {
                cntF++;
            }
            while (cntT > k && cntF > k) {
                if (answerKey[l] == 'T') {
                    cntT--;
                } else {
                    cntF--;
                }
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};