class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int res = 0;
        vector<int> count(60, 0);
        for (int t : time) {
            res += count[(60 - t % 60) % 60];
            count[t % 60]++;
        }
        return res;
    }
};