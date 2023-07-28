impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut i = 0;
        for j in 0..nums2.len() {
            while i < nums1.len() && nums1[i] > nums2[j] {
                i += 1;
            }
            if i < nums1.len() {
                res = res.max(j as i32 - i as i32);
            }
        }
        res
    }
}