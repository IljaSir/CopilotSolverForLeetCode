class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int n = a.size(), m = b.size();
        int i = 0, j = 0;
        int k = 0;
        int times = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                i = 0;
                j = 0;
                k++;
                if (k == n) {
                    k = 0;
                    times++;
                }
            }
        }
        if (j == m) return times + 1;
        if (i == n) return times + 2;
        return -1;
    }
};