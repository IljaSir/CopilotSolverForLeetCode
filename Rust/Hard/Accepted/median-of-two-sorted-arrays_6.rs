impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        
        let mut nums = nums1.clone();
        nums.append(&mut nums2.clone());
        nums.sort_unstable();
        let len = nums.len();
        if len % 2 == 0 {
            (nums[len / 2 - 1] + nums[len / 2]) as f64 / 2.0
        } else {
            nums[len / 2] as f64
        }
    }
}