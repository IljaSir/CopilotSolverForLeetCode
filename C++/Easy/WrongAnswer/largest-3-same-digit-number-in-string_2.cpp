class Solution {
public:
    string largestGoodInteger(string num) {
        
        int n = num.size();
        int cnt[10] = {0};
        for (int i = 0; i < n; i++) {
            cnt[num[i] - '0']++;
        }
        string ans = "";
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] >= 3) {
                ans += string(3, i + '0');
                cnt[i] -= 3;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] > 0) {
                ans += string(cnt[i], i + '0');
                break;
            }
        }
        return ans;
    }
};