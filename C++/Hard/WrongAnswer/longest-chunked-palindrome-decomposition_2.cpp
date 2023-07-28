class Solution {
public:
    int longestDecomposition(string text) {
        
        int n = text.size();
        int i = 0, j = n - 1;
        int ans = 0;
        while (i < j) {
            int k = 1;
            while (i + k <= j && text.substr(i, k) != text.substr(j - k + 1, k)) {
                k++;
            }
            ans += 2;
            i += k;
            j -= k;
        }
        if (i == j) {
            ans++;
        }
        return ans;
    }
};