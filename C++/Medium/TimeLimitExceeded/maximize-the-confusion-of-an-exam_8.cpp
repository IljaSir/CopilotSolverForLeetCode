class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cntF = 0, cntT = 0;
            for (int j = i; j < n; ++j) {
                if (answerKey[j] == 'F') {
                    ++cntF;
                } else {
                    ++cntT;
                }
                if (cntF > k && cntT > k) {
                    break;
                }
                ans = max(ans, j - i + 1);
            }
        }
        return ans;
    }
};