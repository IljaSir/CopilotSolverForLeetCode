class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        vector<int> v(nums.size(),0);
        long long score = 0;
        int i = 0;
        while(i < nums.size()){
            int j = i;
            while(j < nums.size() && v[j] == 1){
                j++;
            }
            if(j == nums.size()){
                break;
            }
            int k = j;
            while(k < nums.size() && v[k] == 0){
                k++;
            }
            int index = j;
            for(int m = j; m < k; m++){
                if(nums[m] < nums[index]){
                    index = m;
                }
            }
            score += nums[index];
            v[index] = 1;
            if(index > 0){
                v[index - 1] = 1;
            }
            if(index < nums.size() - 1){
                v[index + 1] = 1;
            }
            i = index + 1;
        }
        return score;
    }
};