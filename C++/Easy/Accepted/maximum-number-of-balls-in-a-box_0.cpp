class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        vector<int> cnt(46, 0);
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            for (int j = i; j; j /= 10) {
                sum += j % 10;
            }
            cnt[sum]++;
        }
        return *max_element(cnt.begin(), cnt.end());
    }
};