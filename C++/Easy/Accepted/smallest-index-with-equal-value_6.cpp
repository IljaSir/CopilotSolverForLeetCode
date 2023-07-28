class Solution {
public:
    int smallestEqual(vector<int>& nums) {
        
        int min = -1;
        for(int i=0; i<nums.size(); i++) {
            if(i%10 == nums[i]) {
                if(min == -1) {
                    min = i;
                } else {
                    if(i < min) {
                        min = i;
                    }
                }
            }
        }
        return min;
    }
};