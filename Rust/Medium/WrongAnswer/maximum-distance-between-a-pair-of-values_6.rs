impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut max_distance = 0;
        let mut j = nums2.len() - 1;
        for i in 0..nums1.len() {
            while j > i && nums1[i] > nums2[j] {
                j -= 1;
            }
            max_distance = max_distance.max(j - i);
        }
        max_distance as i32
    }
}