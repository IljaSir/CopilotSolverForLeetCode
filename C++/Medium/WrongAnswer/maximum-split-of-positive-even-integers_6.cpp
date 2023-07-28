class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        vector<long long> ans;
        long long sum = 0;
        int cnt = 0;
        while (finalSum > 0) {
            if (finalSum >= 2) {
                ans.push_back(2);
                finalSum -= 2;
                ++cnt;
            }
            else {
                ans.push_back(1);
                finalSum -= 1;
            }
        }
        return ans;
    }
};