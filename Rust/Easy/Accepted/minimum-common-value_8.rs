impl Solution {
    pub fn get_common(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut common = -1;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] == nums2[j] {
                common = nums1[i];
                break;
            } else if nums1[i] < nums2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        common
    }
}