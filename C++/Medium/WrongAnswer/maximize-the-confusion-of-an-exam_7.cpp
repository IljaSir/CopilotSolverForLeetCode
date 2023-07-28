class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int i = 0, j = 0;
        int ans = 0;
        while (i < n && j < n) {
            while (j < n && (answerKey[j] == 'T' || k > 0)) {
                if (answerKey[j] == 'F') k--;
                j++;
            }
            ans = max(ans, j - i);
            if (j < n && answerKey[j] == 'F') {
                while (i < j && answerKey[i] == 'T') i++;
                i++;
                j++;
                k++;
            }
        }
        return ans;
    }
};