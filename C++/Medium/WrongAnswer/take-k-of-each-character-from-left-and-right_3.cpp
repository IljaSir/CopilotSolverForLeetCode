class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.length();
        int i = 0, j = n-1;
        int a = 0, b = 0, c = 0;
        while(i < j) {
            if(s[i] == 'a') {
                a++;
            } else if(s[i] == 'b') {
                b++;
            } else {
                c++;
            }
            if(s[j] == 'a') {
                a++;
            } else if(s[j] == 'b') {
                b++;
            } else {
                c++;
            }
            if(a >= k && b >= k && c >= k) {
                return i+j;
            }
            i++;
            j--;
        }
        return -1;
    }
};