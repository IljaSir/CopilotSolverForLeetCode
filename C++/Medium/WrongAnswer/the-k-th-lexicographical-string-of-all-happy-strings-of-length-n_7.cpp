class Solution {
public:
    string getHappyString(int n, int k) {
        
        string res;
        int cnt = 0;
        int total = 3 * pow(2, n - 1);
        if (k > total) return res;
        char c = 'a';
        while (n--) {
            if (k <= total / 3) {
                res += c;
                c = 'a';
            } else if (k <= total * 2 / 3) {
                res += c + 1;
                c = 'a';
            } else {
                res += c + 2;
                c = 'a';
            }
            total /= 3;
        }
        return res;
    }
};