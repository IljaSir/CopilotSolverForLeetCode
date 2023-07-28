class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> result;
        long long sum = 0;
        for(long long i = 2; i <= finalSum; i += 2) {
            if(sum + i <= finalSum / 2) {
                result.push_back(i);
                sum += i;
            }
        }
        return result;
    }
};