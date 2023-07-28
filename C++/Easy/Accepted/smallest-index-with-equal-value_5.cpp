class Solution {
public:
    int smallestEqual(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while(i < n){
            if(nums[i] == i%10){
                return i;
            }
            i++;
        }
        return -1;
    }
};