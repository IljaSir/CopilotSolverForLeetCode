impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in nums1 {
            if nums2.contains(&i) && !result.contains(&i) {
                result.push(i);
            }
        }
        result
    }
}