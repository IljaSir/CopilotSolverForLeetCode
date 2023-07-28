class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        long long sum = 0;
        long long len = nums.size();
        long long tmp = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            tmp += i * nums[i];
        }
        long long res = tmp;
        for(int i = len - 1; i >= 0; i--){
            tmp = tmp + sum - len * nums[i];
            res = max(res, tmp;
        }
       return ans;
    }
};