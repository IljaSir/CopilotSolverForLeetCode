class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.size();
        if (n < k * 3) return -1;
        int left = 0, right = n - 1;
        int a = 0, b = 0, c = 0;
        int res = 0;
        while (left < right) {
            if (a < k) {
                if (s[left] == 'a') {
                    a++;
                }
                left++;
            }
            if (b < k) {
                if (s[right] == 'b') {
                    b++;
                }
                right--;
            }
            if (c < k) {
                if (s[left] == 'c') {
                    c++;
                }
                left++;
            }
            if (a == k && b == k && c == k) {
                res += left - 1;
                a = 0, b = 0, c = 0;
            }
        }
        if (a == k && b == k && c == k) {
            res += left - 1;
            a = 0, b = 0, c = 0;
        }
        if (a < k || b < k || c < k) return -1;
        return res;
    }
};