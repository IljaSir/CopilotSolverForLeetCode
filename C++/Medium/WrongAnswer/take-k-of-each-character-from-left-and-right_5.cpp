class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.length();
        int left = 0, right = n - 1;
        int a = 0, b = 0, c = 0;
        while (left <= right && (a < k || b < k || c < k)) {
            if (s[left] == 'a') {
                a++;
            } else if (s[left] == 'b') {
                b++;
            } else {
                c++;
            }
            if (s[right] == 'a') {
                a++;
            } else if (s[right] == 'b') {
                b++;
            } else {
                c++;
            }
            left++;
            right--;
        }
        if (a >= k && b >= k && c >= k) {
            return (left - 1) * 2;
        }
        return -1;
    }
};