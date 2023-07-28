class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int res = 0;
        unordered_map<int, int> m;
        for (int t : time) {
            int r = t % 60;
            res += m[(60 - r) % 60];
            ++m[r];
        }
        return res;
    }
};