class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        vector<int> h(60);
        int res = 0;
        for (auto t : time) {
            res += h[(60 - t % 60) % 60];
            ++h[t % 60];
        }
        return res;
    }
};