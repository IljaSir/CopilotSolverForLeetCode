class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int count = 0;
        int n = time.size();
        int remainders[60] = {0};
        for (int i = 0; i < n; i++) {
            int remainder = time[i] % 60;
            if (remainder == 0) {
                count += remainders[remainder];
            } else {
                count += remainders[60 - remainder];
            }
            remainders[remainder]++;
        }
        return count;
    }
};