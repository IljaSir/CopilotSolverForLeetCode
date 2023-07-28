class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.length();
        if (k > n) return -1;
        int left = 0, right = n - 1;
        int count = 0;
        while (left < right) {
            if (s[left] == s[right]) {
                count++;
                left++;
                right--;
            } else {
                break;
            }
        }
        if (count >= k) return 2 * k;
        else return -1;
    }
};