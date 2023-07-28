class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        vector<int> result;
        for (int i = 1; i < n; i++) {
            if (i > 10 && i % 10 == 0) {
                continue;
            }
            int j = n - i;
            int temp = j;
            while (temp > 0) {
                if (temp % 10 == 0) {
                    break;
                }
                temp /= 10;
            }
            if (temp == 0) {
                result.push_back(i);
                result.push_back(j);
                break;
            }
        }
        return result;
    }
};