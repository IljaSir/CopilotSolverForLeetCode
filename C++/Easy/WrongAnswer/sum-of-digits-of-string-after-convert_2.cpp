class Solution {
public:
    int getLucky(string s, int k) {
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s[i] - 'a' + 1);
        }
        if (k == 1) return sum;
        int res = 0;
        while (k--) {
            res = 0;
            while (sum) {
                res += sum % 10;
                sum /= 10;
            }
            sum = res;
        }
        return res;
    }
};