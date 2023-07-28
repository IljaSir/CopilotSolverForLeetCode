class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n+1, 0), even(n+1, 0);
        for(int i=0; i<n; i++) {
            if(i%2) {
                odd[i+1] = odd[i] + nums[i];
                even[i+1] = even[i];
            } else {
                odd[i+1] = odd[i];
                even[i+1] = even[i] + nums[i];
            }
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            if(odd[i] + even[n] - even[i+1] == even[i] + odd[n] - odd[i+1]) {
                res++;
            }
        }
        return res;
    }
};