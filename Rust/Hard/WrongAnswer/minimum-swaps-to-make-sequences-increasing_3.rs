impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let (mut swap, mut not_swap) = (1, 0);
        for i in 1..nums1.len() {
            if nums1[i] <= nums1[i-1] || nums2[i] <= nums2[i-1] {
                swap += 1;
            } else if nums1[i] <= nums2[i-1] || nums2[i] <= nums1[i-1] {
                std::mem::swap(&mut swap, &mut not_swap);
                swap += 1;
            } else {
                let min = std::cmp::min(swap, not_swap);
                swap = min + 1;
                not_swap = min;
            }
        }
        std::cmp::min(swap, not_swap)
    }
}