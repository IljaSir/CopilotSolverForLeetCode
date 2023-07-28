impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        for i in nums1 {
            if nums2.contains(&i) && !res.contains(&i) {
                res.push(i);
            }
        }
        res
    }
}