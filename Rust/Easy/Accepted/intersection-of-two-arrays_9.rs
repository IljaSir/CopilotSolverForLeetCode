impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut res = nums1.iter().filter(|&n| nums2.contains(n)).collect::<Vec<_>>();
        res.sort();
        res.dedup();
        res.iter().map(|&n| *n).collect()
    }
}