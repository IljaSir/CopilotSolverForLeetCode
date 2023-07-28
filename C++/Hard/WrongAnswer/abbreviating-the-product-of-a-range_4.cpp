class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        long long int n = 1;
        for (int i = left; i <= right; i++) {
            n *= i;
            while (n % 10 == 0)
                n /= 10;
            n %= 100000;
        }
        string s = to_string(n);
        while (s.size() < 5)
            s = "0" + s;
        int cnt = 0;
        while (right > 0) {
            right /= 10;
            cnt++;
        }
        return s + "e" + to_string(cnt);
    }
};