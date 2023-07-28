class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        vector<int> count(n, 0);
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && answerKey[j] == answerKey[i]) {
                j++;
            }
            for (int x = i; x < j; x++) {
                count[x] = j - i;
            }
            i = j;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        while (right < n) {
            if (answerKey[right] == 'T') {
                maxCount++;
            }
            if (right - left + 1 - maxCount > k) {
                if (answerKey[left] == 'T') {
                    maxCount--;
                }
                left++;
            }
            res = max(res, right - left + 1);
            right++;
        }
        left = 0;
        right = 0;
        maxCount = 0;
        while (right < n) {
            if (answerKey[right] == 'F') {
                maxCount++;
            }
            if (right - left + 1 - maxCount > k) {
                if (answerKey[left] == 'F') {
                    maxCount--;
                }
                left++;
            }
            res = max(res, right - left + 1);
            right++;
        }
        return res;
    }
};