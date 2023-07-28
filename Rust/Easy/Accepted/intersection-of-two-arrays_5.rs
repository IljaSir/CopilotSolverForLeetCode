impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut v = Vec::new();
        for i in 0..nums1.len() {
            for j in 0..nums2.len() {
                if nums1[i] == nums2[j] {
                    v.push(nums1[i]);
                    break;
                }
            }
        }
        v.sort();
        v.dedup();
        v
    }
}