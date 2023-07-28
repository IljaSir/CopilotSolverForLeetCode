class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        int product = 1;
        for (int i = left; i <= right; ++i) {
            product *= i;
        }
        int count = 0;
        int temp = product;
        while (temp % 10 == 0) {
            ++count;
            temp /= 10;
        }
        int d = 0;
        temp = product;
        while (temp > 0) {
            ++d;
            temp /= 10;
        }
        if (d <= 10) {
            return to_string(product) + "e" + to_string(count);
        }
        else {
            return to_string(product / pow(10, d - 5)) + "..." + to_string(product % (int)pow(10, 5)) + "e" + to_string(count);
        }
    }
};