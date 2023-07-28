class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.size();
        int a = 0, b = 0, c = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (s[i] == 'a') {
                a++;
            } else if (s[i] == 'b') {
                b++;
            } else {
                c++;
            }
            if (s[j] == 'a') {
                a++;
            } else if (s[j] == 'b') {
                b++;
            } else {
                c++;
            }
            if (a >= k && b >= k && c >= k) {
                return i + 1 + n - j;
            }
            i++;
            j--;
        }
        if (i == j) {
            if (s[i] == 'a') {
                a++;
            } else if (s[i] == 'b') {
                b++;
            } else {
                c++;
            }
        }
        if (a >= k && b >= k && c >= k) {
            return i + 1 + n - j;
        }
        return -1;
    }
    int takeCharacters1(string s, int k) {
        int n = s.size();
        int a = 0, b = 0, c = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (s[i] == 'a') {
                a++;
            } else if (s[i] == 'b') {
                b++;
            } else {
                c++;
            }
            if (s[j] == 'a') {
                a++;
            } else if (s[j] == 'b') {
                b++;
            } else {
                c++;
            }
            if (a >= k && b >= k && c >= k) {
                return i + 1 + n - j;
            }
            if (a < k) {
                i++;
            }
            if (b < k) {
                i++;
            }
            if (c < k) {
                i++;
            }
            if (a < k) {
                j--;
            }
            if (b < k) {
                j--;
            }
            if (c < k) {
                j--;
            }
        }
        if (i == j) {
    }
};