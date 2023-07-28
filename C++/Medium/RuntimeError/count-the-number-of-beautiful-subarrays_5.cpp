class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        vector<int> oddIndex;
        oddIndex.push_back(-1);
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] % 2 == 1){
                oddIndex.push_back(i);
            }
        }
        oddIndex.push_back(nums.size());
        long long ans = 0;
        for(int i = 1; i < oddIndex.size(); i++){
            ans += (oddIndex[i] - oddIndex[i - 1]) * (oddIndex[i + 1] - oddIndex[i]);
        }
        return ans;
    }
};