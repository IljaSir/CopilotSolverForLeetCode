class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int n = nums.size();
        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == key){
                int j = i + 1;
                while(j < n && nums[j] == nums[i]){
                    j++;
                }
                if(j < n){
                    if(cnt < j - i){
                        ans = nums[j];
                        cnt = j - i;
                    }
                    i = j - 1;
                }
            }
        }
        return ans;
    }
};