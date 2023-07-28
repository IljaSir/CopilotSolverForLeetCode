class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int n = nums.size();
        int pos = 0;
        int neg = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] >= 0) {
                pos++;
                if(neg > 0) {
                    if(pos > max) {
                        max = pos;
                    }
                    pos = 0;
                    neg = 0;
                }
            } else {
                neg++;
                if(pos > 0) {
                    if(neg > max) {
                        max = neg;
                    }
                    pos = 0;
                    neg = 0;
                }
            }
        }
        if(pos > 0 && pos > max) {
            max = pos;
        }
        if(neg > 0 && neg > max) {
            max = neg;
        }
        return max;
    }
};