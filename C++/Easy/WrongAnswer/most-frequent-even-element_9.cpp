class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        int max = 0;
        int maxNum = 0;
        int count[100001] = {0};
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] % 2 == 0){
                count[nums[i]]++;
                if(count[nums[i]] > max){
                    max = count[nums[i]];
                    maxNum = nums[i];
                }
            }
        }
        if(max == 0){
            return -1;
        }
        return maxNum;
    }
};