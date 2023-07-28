class Solution {
public:
    string largestGoodInteger(string num) {
        
        int cnt[10] = {0};
        for (auto c : num) {
            cnt[c - '0']++;
        }
        string ans = "";
        for (int i = 9; i >= 0; i--) {
            int n = cnt[i];
            if (n >= 3) {
                for (int j = 0; j < n / 3; j++) {
                    ans += to_string(i);
                }
            }
        }
        return ans;
    }
};