class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> ans;
        long long sum = 0;
        for (long long i = 2; i <= finalSum; i += 2) {
            sum += i;
            ans.push_back(i);
            if (sum >= finalSum) {
                break;
            }
        }
        return ans;
    }
};