impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result: Vec<Vec<i32>> = vec![vec![], vec![]];
        for i in nums1 {
            if !nums2.contains(&i) {
                result[0].push(i);
            }
        }
        for i in nums2 {
            if !nums1.contains(&i) {
                result[1].push(i);
            }
        }
        result
    }
}