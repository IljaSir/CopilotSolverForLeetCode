class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int n = a.length(), m = b.length();
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j < m && a[(i + j) % n] == b[j]) j++;
            if (j == m) {
                if (i == 0 || (i + j) % n == 0) return (i + j) / n;
                else return (i + j) / n + 1;
            }
            i++;
        }
        return -1;
    }
};