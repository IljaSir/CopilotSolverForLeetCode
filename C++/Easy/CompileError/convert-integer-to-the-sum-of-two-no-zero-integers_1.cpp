class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        for (int i = 1; i < n; i++) {
            if (isNoZero(i) && isNoZero(n - i)) {
                return {i, n - i};
            }
        }
        return {};
    }
};