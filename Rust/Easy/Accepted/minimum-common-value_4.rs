impl Solution {
    pub fn get_common(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut min = -1;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] == nums2[j] {
                if min == -1 || nums1[i] < min {
                    min = nums1[i];
                }
                i += 1;
                j += 1;
            } else if nums1[i] > nums2[j] {
                j += 1;
            } else {
                i += 1;
            }
        }
        min
    }
}