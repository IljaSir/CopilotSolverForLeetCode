class Solution {
public:
    int maxScore(string s) {
        
        int n = s.size();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                right++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            if (s[i] == '0') {
                left++;
            } else {
                right--;
            }
            ans = max(ans, left + right);
        }
        return ans;
    }
};