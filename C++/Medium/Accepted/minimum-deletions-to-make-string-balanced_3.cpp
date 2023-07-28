class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                right++;
            }
        }
        int ans = right;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                right--;
            } else {
                left++;
            }
            ans = min(ans, left + right);
        }
        return ans;
    }
};