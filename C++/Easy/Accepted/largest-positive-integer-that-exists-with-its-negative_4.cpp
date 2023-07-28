class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        unordered_set<int> set;
        for(int i = 0; i < nums.size(); i++){
            set.insert(nums[i]);
        }
        int max = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] > 0 && set.find(-nums[i]) != set.end()){
                if(nums[i] > max){
                    max = nums[i];
                }
            }
        }
        if(max == 0){
            return -1;
        }
        return max;
    }
    int largestMagicalString(int n) {
        vector<int> nums(n);
        int i = 0;
        int j = 0;
        int count = 1;
        while(j < n){
            if(i % 2 == 0){
                nums[j] = 1;
                j++;
            }else{
                for(int k = 0; k < count && j < n; k++){
                    nums[j] = 2;
                    j++;
                }
                count++;
            }
            i++;
        }
        return findMaxK(nums);
    }
};