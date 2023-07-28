impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let (mut swap, mut no_swap) = (1, 0);
        for i in 1..nums1.len() {
            let (mut swap_, mut no_swap_) = (nums1.len() as i32, nums1.len() as i32);
            if nums1[i-1] < nums1[i] && nums2[i-1] < nums2[i] {
                swap_ = swap + 1;
                no_swap_ = no_swap;
            }
            if nums1[i-1] < nums2[i] && nums2[i-1] < nums1[i] {
                swap_ = swap_.min(no_swap + 1);
                no_swap_ = no_swap_.min(swap);
            }
            swap = swap_;
            no_swap = no_swap_;
        }
        swap.min(no_swap)
    }
}