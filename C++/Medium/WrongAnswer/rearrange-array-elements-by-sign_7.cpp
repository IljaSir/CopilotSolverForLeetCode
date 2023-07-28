class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> res(n);
        int i = 0, j = n-1;
        int k = 0;
        while (i < j) {
            res[k++] = nums[i++];
            res[k++] = nums[j--];
        }
        if (i == j) {
            res[k] = nums[i];
        }
        return res;
    }
};