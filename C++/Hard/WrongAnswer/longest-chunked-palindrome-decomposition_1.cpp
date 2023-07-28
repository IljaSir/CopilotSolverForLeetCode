class Solution {
public:
    int longestDecomposition(string text) {
        
        int n = text.size();
        int i = 0, j = n - 1;
        int ans = 0;
        while (i <= j) {
            int k = 0;
            while (i + k <= j - k && text[i + k] == text[j - k]) {
                ++k;
            }
            if (k == 0) {
                ++ans;
                ++i;
                --j;
            } else {
                ans += 2;
                i += k;
                j -= k;
            }
        }
        return ans;
    }
};