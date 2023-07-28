class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int i = 0, j = 0, k = 0;
        int l = a.length(), m = b.length();
        while(i < l && j < m) {
            if(a[i] == b[j]) {
                i++;
                j++;
            } else {
                i = 0;
                j = 0;
                k++;
            }
        }
        if(j < m) return -1;
        return k + 1;
    }
};