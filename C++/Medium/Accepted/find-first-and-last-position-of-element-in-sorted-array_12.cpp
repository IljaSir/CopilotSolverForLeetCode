class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int left = 0;
        int right = nums.size() - 1;
        int mid = 0;
        int pos = -1;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                pos = mid;
                break;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        if(pos == -1){
            return {-1, -1};
        }
        
        int leftPos = pos;
        int rightPos = pos;
        
        while(leftPos > 0 && nums[leftPos - 1] == target){
            leftPos--;
        }
        while(rightPos < nums.size() - 1 && nums[rightPos + 1] == target){
            rightPos++;
        }
        
        return {leftPos, rightPos};
    }
};