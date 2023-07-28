class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> res;
        long long n = 1;
        while (finalSum > 0) {
            if (finalSum <= n) {
                res.push_back(finalSum);
                break;
            }
            res.push_back(n);
            finalSum -= n;
            n <<= 1;
        }
        return res;
    }
};