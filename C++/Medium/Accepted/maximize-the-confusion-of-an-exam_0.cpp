class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        
        int n = answerKey.size();
        int l = 0, r = 0;
        int cnt = 0;
        int ans = 0;
        while (r < n) {
            if (answerKey[r] == 'F') {
                cnt++;
            }
            while (cnt > k) {
                if (answerKey[l++] == 'F') {
                    cnt--;
                }
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        l = 0, r = 0;
        cnt = 0;
        while (r < n) {
            if (answerKey[r] == 'T') {
                cnt++;
            }
            while (cnt > k) {
                if (answerKey[l++] == 'T') {
                    cnt--;
                }
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};