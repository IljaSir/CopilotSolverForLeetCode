class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        int num = 1;
        for (int i = left; i <= right; ++i) {
            num *= i;
        }
        int count = 0;
        while (num % 10 == 0) {
            num /= 10;
            ++count;
        }
        string num_str = to_string(num);
        int len = num_str.size();
        if (len <= 10) {
            return num_str + "e" + to_string(count);
        }
        else {
            return num_str.substr(0, 5) + "..." + num_str.substr(len - 5, 5) + "e" + to_string(count);
        }
    }
};