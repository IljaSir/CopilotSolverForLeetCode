class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int ans = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (s[left] == '0') {
                ans++;
                left++;
            } else {
                if (s[right] == '1') {
                    ans++;
                    right--;
                } else {
                    ans += 2;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
};