class Solution {
public:
    int countEven(int num) {
        
        int c = 0;
        while(num){
            if(num%2==0) c++;
            num/=10;
        }
        return c;
    }
    int findNumbers(vector<int>& nums) {
        int c = 0;
        for(int i=0;i<nums.size();i++){
            if(countEven(nums[i])%2==0) c++;
        }
        return c;
    }
};