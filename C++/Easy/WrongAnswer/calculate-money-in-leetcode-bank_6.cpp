class Solution {
public:
    int totalMoney(int n) {
        
        int sum = 0;
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; ++i) {
            if (i % 7 == 0) {
                a = 1;
                b = i / 7 + 1;
            }
            sum += a + b;
            a++;
        }
        return sum;
    }
};