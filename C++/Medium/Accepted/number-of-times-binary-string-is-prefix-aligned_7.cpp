class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int count = 0;
        int max = flips[0];
        for(int i = 0; i < flips.size(); i++) {
            if(flips[i] > max) {
                max = flips[i];
            }
            if(max == i + 1) {
                count++;
            }
        }
        return count;
    }
};