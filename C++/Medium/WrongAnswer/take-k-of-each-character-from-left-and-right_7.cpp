class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.size();
        int i = 0, j = n - 1;
        int cnt = 0;
        while (i < j) {
            if (s[i] == s[j]) {
                cnt++;
                i++;
                j--;
            } else {
                break;
            }
        }
        if (cnt >= k) {
            return (n - 2 * k);
        } else {
            return -1;
        }
    }
};