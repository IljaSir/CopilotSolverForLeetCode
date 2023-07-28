class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int res = 0;
        vector<int> count(46, 0);
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0, num = i;
            while (num) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
            res = max(res, count[sum]);
        }
        return res;
    }
};