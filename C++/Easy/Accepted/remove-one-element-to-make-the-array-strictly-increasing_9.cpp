class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]>=nums[i+1]){
                if(i==0){
                    nums.erase(nums.begin()+i);
                    return isSorted(nums);
                }
                else if(i==nums.size()-2){
                    nums.erase(nums.begin()+i+1);
                    return isSorted(nums);
                }
                else{
                    vector<int> temp=nums;
                    temp.erase(temp.begin()+i);
                    if(isSorted(temp)) return true;
                    temp=nums;
                    temp.erase(temp.begin()+i+1);
                    if(isSorted(temp)) return true;
                    return false;
                }
            }
        }
        return true;
    }
    bool isSorted(vector<int> nums){
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]>=nums[i+1]) return false;
        }
        return true;
    }
};