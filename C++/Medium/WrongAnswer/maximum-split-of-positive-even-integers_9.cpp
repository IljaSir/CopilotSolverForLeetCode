class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> res;
        long long sum = 0;
        int i = 1;
        while(sum < finalSum) {
            sum += 2;
            res.push_back(2);
        }
        if(sum == finalSum) return res;
        int j = 0;
        while(sum > finalSum) {
            sum -= 2;
            res[j] = 1;
            j++;
        }
        return res;
    }
};