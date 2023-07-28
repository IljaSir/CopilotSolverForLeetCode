class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;
            if (a % 10 != 0 && b % 10 != 0) {
                if (a / 10 % 10 != 0 && b / 10 % 10 != 0) {
                    if (a / 100 % 10 != 0 && b / 100 % 10 != 0) {
                        if (a / 1000 % 10 != 0 && b / 1000 % 10 != 0) {
                            if (a / 10000 % 10 != 0 && b / 10000 % 10 != 0) {
                                return {a, b};
                            }
                        }
                    }
                }
            }
        }
        return {};
    }
};