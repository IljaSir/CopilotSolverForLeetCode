impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        
        let mut nums: Vec<i32> = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] < nums2[j] {
                nums.push(nums1[i]);
                i += 1;
            } else {
                nums.push(nums2[j]);
                j += 1;
            }
        }
        while i < nums1.len() {
            nums.push(nums1[i]);
            i += 1;
        }
        while j < nums2.len() {
            nums.push(nums2[j]);
            j += 1;
        }
        let mid = nums.len() / 2;
        if nums.len() % 2 == 0 {
            (nums[mid - 1] + nums[mid]) as f64 / 2.0
        } else {
            nums[mid] as f64
        }
    }
}