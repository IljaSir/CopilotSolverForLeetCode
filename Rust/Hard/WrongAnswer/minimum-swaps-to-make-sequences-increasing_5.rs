impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        use std::cmp::min;
        let n = nums1.len();
        let mut dp1 = vec![0; n];
        let mut dp2 = vec![1; n];
        for i in 1..n {
            if nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1] {
                if nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1] {
                    dp2[i] = min(dp1[i-1], dp2[i-1]) + 1;
                }
                dp1[i] = dp1[i-1];
            } else {
                dp1[i] = dp2[i-1];
                dp2[i] = dp1[i-1] + 1;
            }
        }
        min(dp1[n-1], dp2[n-1])
    }
}