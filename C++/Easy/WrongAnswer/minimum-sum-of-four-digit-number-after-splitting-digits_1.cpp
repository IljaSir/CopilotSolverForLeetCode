class Solution {
public:
    int minimumSum(int num) {
        
        int a = num / 1000;
        int b = (num - a * 1000) / 100;
        int c = (num - a * 1000 - b * 100) / 10;
        int d = num % 10;
        int ans = 10000;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                int x = 0, y = 0;
                if (i == 0) x = a * 1000;
                else if (i == 1) x = a * 100 + b * 100;
                else if (i == 2) x = a * 10 + b * 10 + c * 10;
                else x = a + b + c + d;
                if (j == 0) y = b * 1000 + c * 100 + d * 10;
                else if (j == 1) y = b * 100 + c * 100 + d * 10;
                else if (j == 2) y = b * 10 + c * 10 + d * 10;
                else y = b + c + d;
                ans = min(ans, x + y);
            }
        }
        return ans;
    }
};