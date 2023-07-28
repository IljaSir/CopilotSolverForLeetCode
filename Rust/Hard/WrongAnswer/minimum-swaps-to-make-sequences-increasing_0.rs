impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut swap = 1;
        let mut no_swap = 0;
        for i in 1..nums1.len() {
            if nums1[i-1] >= nums1[i] || nums2[i-1] >= nums2[i] {
                swap += 1;
            } else if nums1[i-1] >= nums2[i] || nums2[i-1] >= nums1[i] {
                swap = no_swap + 1;
            } else {
                let tmp = swap;
                swap = no_swap + 1;
                no_swap = tmp.min(no_swap);
            }
        }
        swap.min(no_swap)
    }
}