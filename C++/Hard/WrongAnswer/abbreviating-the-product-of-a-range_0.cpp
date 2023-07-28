class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        int count = 0;
        long long product = 1;
        for (int i = left; i <= right; i++) {
            product *= i;
            while (product % 10 == 0) {
                product /= 10;
                count++;
            }
            product %= 10000000000;
        }
        string result = to_string(product);
        if (product >= 100000) {
            result = to_string(product / 100000) + "..." + to_string(product % 100000);
        }
        result += "e" + to_string(count);
        return result;
    }
};