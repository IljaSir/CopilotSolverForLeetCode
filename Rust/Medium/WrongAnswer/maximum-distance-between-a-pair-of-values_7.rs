impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut j = 0;
        for (i, &n1) in nums1.iter().enumerate() {
            while j < nums2.len() && n1 <= nums2[j] {
                j += 1;
            }
            if j > 0 {
                max = std::cmp::max(max, j - i - 1);
            }
        }
        max as i32
    }
}