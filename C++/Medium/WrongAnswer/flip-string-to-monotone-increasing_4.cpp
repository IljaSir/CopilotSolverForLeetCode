class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        int ones = 0;
        int flips = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == '1') {
                ones++;
            } else {
                if(ones == 0) {
                    continue;
                } else {
                    flips++;
                }
            }
            if(flips > ones) {
                ones = flips;
            }
        }
        return flips;
    }
};