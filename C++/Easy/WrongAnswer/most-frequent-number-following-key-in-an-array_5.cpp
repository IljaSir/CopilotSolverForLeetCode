class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int max = 0;
        int index = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] == key){
                int count = 1;
                for(int j = i+1; j < nums.size(); j++){
                    if(nums[i] == nums[j]){
                        count++;
                    }
                    else{
                        break;
                    }
                }
                if(count > max){
                    max = count;
                    index = i;
                }
            }
        }
        return nums[index+1];
    }
};