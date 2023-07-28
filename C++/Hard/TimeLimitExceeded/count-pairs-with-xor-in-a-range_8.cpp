class Solution {
public:
    int countPairs(vector<int>& nums, int low, int high) {
        
        int n = nums.size();
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int x = nums[i]^nums[j];
                if(x >= low && x <= high){
                    res ++;
                }
            }
        }
        return res;
    }
};