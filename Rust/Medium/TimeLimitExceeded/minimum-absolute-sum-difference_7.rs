impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        let mut diff = 0;
        let mut max = 0;
        for i in 0..nums1.len() {
            let abs = (nums1[i] - nums2[i]).abs();
            diff += abs;
            let mut min = abs;
            for j in 0..nums1.len() {
                let abs = (nums1[j] - nums2[i]).abs();
                if abs < min {
                    min = abs;
                }
            }
            if min < abs {
                max = max.max(abs - min);
            }
        }
        (diff - max) % 1_000_000_007
    }
}