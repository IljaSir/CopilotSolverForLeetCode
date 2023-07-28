impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut diff = 0;
        let mut max_diff = 0;
        let mut nums1 = nums1.clone();
        let n = nums1.len();
        nums1.sort();
        for i in 0..n {
            let d = (nums1[i] - nums2[i]).abs();
            diff = (diff + d) % 1000000007;
            let j = nums1.binary_search(&(nums2[i])).unwrap_or_else(|x| x);
            if j < n {
                max_diff = max_diff.max(d - (nums1[j] - nums2[i]).abs());
            }
            if j > 0 {
                max_diff = max_diff.max(d - (nums1[j - 1] - nums2[i]).abs());
            }
        }
        (diff as i64 - max_diff as i64).rem_euclid(1000000007) as i32
    }
}