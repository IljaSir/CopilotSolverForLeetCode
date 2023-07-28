class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int sum = 0;
        int max = 0;
        int max1 = 0;
        int max2 = 0;
        for(int i=0; i<nums.size(); i++){
            sum = 0;
            int temp = nums[i];
            while(temp){
                sum += temp%10;
                temp /= 10;
            }
            if(sum > max){
                max = sum;
                max1 = nums[i];
            }
        }
        for(int i=0; i<nums.size(); i++){
            sum = 0;
            int temp = nums[i];
            while(temp){
                sum += temp%10;
                temp /= 10;
            }
            if(sum == max && nums[i] != max1){
                max2 = nums[i];
                break;
            }
        }
        if(max2 == 0) return -1;
        return max1+max2;
    }
};