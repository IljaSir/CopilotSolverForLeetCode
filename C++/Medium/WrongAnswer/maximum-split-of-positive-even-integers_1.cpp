class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> res;
        long long sum = 0;
        long long i = 2;
        while(sum < finalSum){
            res.push_back(i);
            sum += i;
            i += 2;
        }
        if(sum > finalSum){
            res[res.size()-1] -= sum - finalSum;
        }
        return res;
    }
};