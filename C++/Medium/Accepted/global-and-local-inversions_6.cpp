class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        
        int n = nums.size();
        int max = 0;
        for(int i = 0; i < n - 2; i++){
            max = nums[i] > max ? nums[i] : max;
            if(max > nums[i + 2]) return false;
        }
        return true;
    }
};