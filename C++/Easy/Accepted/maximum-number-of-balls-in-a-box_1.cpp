class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int res = 0;
        map<int, int> m;
        for (int i = lowLimit; i <= highLimit; ++i) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += j % 10;
            }
            m[sum]++;
            res = max(res, m[sum]);
        }
        return res;
    }
};