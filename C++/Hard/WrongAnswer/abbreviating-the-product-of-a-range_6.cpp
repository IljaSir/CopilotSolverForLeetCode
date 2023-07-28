class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        int n = right - left + 1;
        int c = 0;
        for (int i = left; i <= right; i++) {
            while (i % 10 == 0) {
                c++;
                i /= 10;
            }
        }
        string pre = to_string(left), suf = to_string(right);
        if (pre.size() + suf.size() > 10) {
            pre = pre.substr(0, 5);
            suf = suf.substr(suf.size() - 5);
        }
        if (c > 0) {
            pre += "...";
        }
        return pre + suf + "e" + to_string(c);
    }
};