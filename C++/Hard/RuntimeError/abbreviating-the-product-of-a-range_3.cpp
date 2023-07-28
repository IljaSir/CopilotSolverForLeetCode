class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        long long product = 1;
        for (int i = left; i <= right; ++i) {
            product *= i;
        }
        string s = to_string(product);
        int n = s.size();
        int count = 0;
        int i = n - 1;
        while (i >= 0 && s[i] == '0') {
            ++count;
            --i;
        }
        if (n - count > 10) {
            string pre = s.substr(0, 5);
            string suf = s.substr(n - count - 5, 5);
            return pre + "..." + suf + "e" + to_string(count);
        }
        else {
            return s.substr(0, n - count) + "e" + to_string(count);
        }
    }
};