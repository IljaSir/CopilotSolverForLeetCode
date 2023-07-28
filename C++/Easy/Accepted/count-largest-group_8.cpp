class Solution {
public:
    int countLargestGroup(int n) {
        
        int res = 0;
        vector<int> v(37, 0);
        for (int i = 1; i <= n; ++i) {
            int sum = 0, num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            ++v[sum];
        }
        int maxVal = 0;
        for (int i = 0; i < v.size(); ++i) {
            maxVal = max(maxVal, v[i]);
        }
        for (int i = 0; i < v.size(); ++i) {
            if (v[i] == maxVal) {
                ++res;
            }
        }
        return res;
    }
};