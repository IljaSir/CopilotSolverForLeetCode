class Solution {
public:
    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int no_swap = 0;
        int swap = 1;
        for (int i = 1; i < n; i++) {
            int no_swap_tmp = INT_MAX;
            int swap_tmp = INT_MAX;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                no_swap_tmp = min(no_swap_tmp, no_swap);
                swap_tmp = min(swap_tmp, swap + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                no_swap_tmp = min(no_swap_tmp, swap);
                swap_tmp = min(swap_tmp, no_swap + 1);
            }
            no_swap = no_swap_tmp;
            swap = swap_tmp;
        }
        return min(no_swap, swap);
    }
};