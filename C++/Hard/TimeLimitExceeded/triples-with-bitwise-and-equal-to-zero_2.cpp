class Solution {
public:
    int countTriplets(vector<int>& nums) {
        
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                for (int k = 0; k < nums.size(); k++) {
                    if ((nums[i] & nums[j] & nums[k]) == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
};