class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int f = 0, t = 0;
        int i = 0, j = 0;
        int res = 0;
        while (j < n) {
            if (answerKey[j] == 'F') f++;
            if (answerKey[j] == 'T') t++;
            while (f > k) {
                if (answerKey[i] == 'F') f--;
                i++;
            }
            while (t > k) {
                if (answerKey[i] == 'T') t--;
                i++;
            }
            res = max(res, j - i + 1);
            j++;
        }
        return res;
    }
};