class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        long long product = 1;
        for (int i = left; i <= right; i++) {
            product *= i;
        }
        string productStr = to_string(product);
        int tailZeros = 0;
        for (int i = productStr.size() - 1; i >= 0; i--) {
            if (productStr[i] == '0') {
                tailZeros++;
            } else {
                break;
            }
        }
        int digits = productStr.size() - tailZeros;
        if (digits > 10) {
            productStr = productStr.substr(0, 5) + "..." + productStr.substr(productStr.size() - 5, 5);
        }
        return productStr + "e" + to_string(tailZeros);
    }
};