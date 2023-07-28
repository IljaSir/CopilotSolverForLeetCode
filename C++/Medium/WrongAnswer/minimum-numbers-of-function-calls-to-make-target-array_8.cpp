class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int max = 0, count = 0;
        for(int i = 0; i < nums.size(); i++){
            int j = 0;
            while(nums[i] > 0){
                if(nums[i] & 1)
                    count++;
                nums[i] >>= 1;
                j++;
            }
            if(j > max)
                max = j;
        }
        return count + max - 1;
    }
};