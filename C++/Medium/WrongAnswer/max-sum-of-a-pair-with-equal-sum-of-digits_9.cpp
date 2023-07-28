class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int n = nums.size();
        int s = 0;
        int maxs = -1;
        for(auto i : nums){
            s = 0;
            while(i){
                s += i%10;
                i /= 10;
            }
            if(s > maxs){
                maxs = s;
            }
        }
        int maxsum = -1;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                s = 0;
                int a = nums[i];
                while(a){
                    s += a%10;
                    a /= 10;
                }
                int b = nums[j];
                while(b){
                    s += b%10;
                    b /= 10;
                }
                if(s == maxs){
                    if(nums[i] + nums[j] > maxsum){
                        maxsum = nums[i] + nums[j];
                    }
                }
            }
        }
        return maxsum;
    }
};