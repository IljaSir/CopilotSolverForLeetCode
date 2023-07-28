class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> tmp = nums;
        sort(tmp.begin(), tmp.end());
        int i = (n - 1) / 2, j = n - 1;
        for (int k = 0; k < n; k++) {
            nums[k] = (k & 1) ? tmp[j--] : tmp[i--];
        }
    }
};