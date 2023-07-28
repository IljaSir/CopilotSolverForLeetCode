class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = 1;
        while(j < n){
            int tmp = nums[j];
            int k = j;
            while(k > i){
                nums[k] = nums[k-1];
                k--;
            }
            nums[i] = tmp;
            i += 2;
            j += 2;
        }
        return nums;
    }
};