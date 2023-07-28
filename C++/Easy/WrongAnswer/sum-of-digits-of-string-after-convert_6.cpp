class Solution {
public:
    int getLucky(string s, int k) {
        
        int sum = 0;
        for (char c : s) {
            sum += c - 'a' + 1;
        }
        while (k-- > 1) {
            int t = 0;
            while (sum > 0) {
                t += sum % 10;
                sum /= 10;
            }
            sum = t;
        }
        return sum;
    }
};