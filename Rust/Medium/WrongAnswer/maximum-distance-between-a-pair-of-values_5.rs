impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] > nums2[j] {
                i += 1;
            } else {
                if j - i > max {
                    max = j - i;
                }
                j += 1;
            }
        }
        max as i32
    }
}