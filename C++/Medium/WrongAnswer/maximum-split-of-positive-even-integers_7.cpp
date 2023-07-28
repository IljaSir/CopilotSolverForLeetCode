class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        if (finalSum % 2 != 0) return {};
        vector<long long> res;
        long long n = finalSum / 2;
        while (n >= 2) {
            res.push_back(n);
            n /= 2;
        }
        return res;
    }
};