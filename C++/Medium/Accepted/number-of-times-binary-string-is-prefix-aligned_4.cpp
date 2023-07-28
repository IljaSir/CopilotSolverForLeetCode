class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int count = 0;
        int max = 0;
        for(int i = 0; i < flips.size(); i++) {
            if(flips[i] > max) {
                max = flips[i];
            }
            if(i == max - 1) {
                count++;
            }
        }
        return count;
    }
};