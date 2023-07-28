impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 0..nums1.len() {
            let diff = (nums1[i] - nums2[i]).abs();
            sum = (sum + diff) % 1000000007;
            let mut min = diff;
            for j in 0..nums1.len() {
                min = min.min((nums1[j] - nums2[i]).abs());
            }
            max = max.max(diff - min);
        }
        (sum + 1000000007 - max) % 1000000007
    }
}