class Solution {
public:
    string largestGoodInteger(string num) {
        
        int n = num.size();
        int cnt[10] = {0};
        for (int i = 0; i < n; ++i) {
            cnt[num[i] - '0']++;
        }
        int largest = -1;
        for (int i = 0; i < 10; ++i) {
            if (cnt[i] >= 3) {
                largest = i;
            }
        }
        if (largest == -1) {
            return "";
        }
        string ans = "";
        for (int i = 0; i < n; ++i) {
            if (num[i] - '0' == largest) {
                ans += num[i];
            }
        }
        return ans;
    }
};