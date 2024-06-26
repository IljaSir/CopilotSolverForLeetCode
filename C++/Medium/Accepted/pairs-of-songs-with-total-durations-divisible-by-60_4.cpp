class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int count = 0;
        vector<int> v(60, 0);
        for (int t : time) {
            count += v[(60 - t % 60) % 60];
            ++v[t % 60];
        }
        return count;
    }
};