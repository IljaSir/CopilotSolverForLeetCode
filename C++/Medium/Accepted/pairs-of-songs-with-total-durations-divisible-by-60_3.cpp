class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int ans = 0;
        vector<int> rem(60, 0);
        for (int t : time) {
            ans += rem[(60 - t % 60) % 60];
            rem[t % 60]++;
        }
        return ans;
    }
};