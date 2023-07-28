class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> tmp = nums;
        sort(tmp.begin(), tmp.end());
        int i = n - 1, j = (n - 1) / 2, k = 0;
        while (k < n) {
            nums[k++] = tmp[j--];
            if (k < n) nums[k++] = tmp[i--];
        }
    }
};