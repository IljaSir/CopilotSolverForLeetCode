impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max_diff = 0;
        let mut sorted_nums1 = nums1.clone();
        sorted_nums1.sort();
        for i in 0..nums1.len() {
            let diff = (nums1[i] - nums2[i]).abs();
            sum += diff;
            let j = sorted_nums1.binary_search(&nums2[i]).unwrap_or_else(|x| x);
            if j > 0 {
                max_diff = max_diff.max(diff - (sorted_nums1[j - 1] - nums2[i]).abs());
            }
            if j < nums1.len() {
                max_diff = max_diff.max(diff - (sorted_nums1[j] - nums2[i]).abs());
            }
        }
        ((sum - max_diff) % 1_000_000_007) as i32
    }
}