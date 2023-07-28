class Solution {
public:
    string largestPalindromic(string num) {
        
        int n = num.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (num[i] == num[j]) {
                    int l = i, r = j;
                    while (l >= 0 && r < n && num[l] == num[r]) {
                        --l;
                        ++r;
                    }
                    if (l < 0) {
                        int tmp = stoi(num.substr(i, j - i + 1));
                        ans = max(ans, tmp);
                    }
                }
            }
        }
        return to_string(ans);
    }
};