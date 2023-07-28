class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        std::map<int, int> m;
        for (int i = lowLimit; i <= highLimit; ++i) {
            int t = i;
            int sum = 0;
            while (t) {
                sum += t % 10;
                t /= 10;
            }
            m[sum]++;
        }
        int max = 0;
        for (auto it = m.begin(); it != m.end(); ++it) {
            if (it->second > max) {
                max = it->second;
            }
        }
        return max;
    }
};