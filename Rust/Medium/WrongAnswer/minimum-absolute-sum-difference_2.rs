impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut max_diff = 0;
        let mut sum = 0;
        for i in 0..nums1.len() {
            let diff = (nums1[i] - nums2[i]).abs();
            if diff > max_diff {
                max_diff = diff;
            }
            sum += diff;
        }
        let mut min_diff = max_diff;
        nums1.sort();
        for i in 0..nums1.len() {
            let diff = (nums1[i] - nums2[i]).abs();
            if diff < min_diff {
                min_diff = diff;
            }
            sum += diff;
        }
        sum as i32
    }
}