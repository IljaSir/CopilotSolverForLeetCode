class Solution {
public:
    int longestDecomposition(string text) {
        
        int n = text.size();
        if (n == 0) return 0;
        if (n == 1) return 1;
        string left = "";
        string right = "";
        for (int i = 0; i < n; i++) {
            left += text[i];
            right = text[n - 1 - i] + right;
            if (left == right) {
                return 2 + longestDecomposition(text.substr(i + 1, n - 2 * (i + 1)));
            }
        }
        return 1;
    }
};