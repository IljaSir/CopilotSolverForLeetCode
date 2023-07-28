class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int n = highLimit - lowLimit + 1;
        int res = 0;
        unordered_map<int, int> mp;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0, num = i;
            while (num) {
                sum += num % 10;
                num /= 10;
            }
            mp[sum]++;
            res = max(res, mp[sum]);
        }
        return res;
    }
};