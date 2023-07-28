class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> result;
        int i = 1;
        while (finalSum > 0) {
            if (finalSum % 2 == 0) {
                result.push_back(i);
                finalSum -= i;
            }
            i++;
        }
        return result;
    }
};