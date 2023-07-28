class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> res;
        long long sum = 0;
        while (finalSum > 0) {
            if (finalSum % 2 == 0) {
                sum += finalSum;
                res.push_back(finalSum);
                finalSum = 0;
            } else {
                sum += finalSum - 1;
                res.push_back(finalSum - 1);
                finalSum = 1;
            }
        }
        return res;
    }
};