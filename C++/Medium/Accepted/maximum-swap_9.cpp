class Solution {
public:
    int maximumSwap(int num) {
        
        string str = to_string(num);
        int n = str.size();
        int i = 0;
        // find the first digit that is not the largest in the remaining digits
        while (i < n - 1 && str[i] >= str[i + 1]) {
            ++i;
        }
        if (i == n - 1) {
            return num;
        }
        // find the largest digit in the remaining digits
        int maxIndex = i + 1;
        for (int j = i + 2; j < n; ++j) {
            if (str[j] >= str[maxIndex]) {
                maxIndex = j;
            }
        }
        // find the first digit that is smaller than the largest digit
        for (int j = 0; j < i + 1; ++j) {
            if (str[j] < str[maxIndex]) {
                swap(str[j], str[maxIndex]);
                break;
            }
        }
        return stoi(str);
    }
};