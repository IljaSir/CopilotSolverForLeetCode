class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        sort(nums.begin(),nums.end());
        int n = nums.size();
        int res = 0;
        for(int i = 0;i<n;i++){
            if(i == n-1 || nums[i] != nums[i+1]){
                res += i;
            }
        }
        return res;
    }
};