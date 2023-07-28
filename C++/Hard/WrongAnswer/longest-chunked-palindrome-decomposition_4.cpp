class Solution {
public:
    int longestDecomposition(string text) {
        
        int n = text.size();
        int i = 0;
        int j = n-1;
        int res = 0;
        while (i < j) {
            int k = 0;
            while (i + k <= j - k && text[i + k] == text[j - k]) {
                k++;
            }
            if (k == 0) {
                i++;
                j--;
                res += 2;
            } else {
                i += k;
                j -= k;
            }
        }
        if (i == j) {
            res++;
        }
        return res;
    }
};