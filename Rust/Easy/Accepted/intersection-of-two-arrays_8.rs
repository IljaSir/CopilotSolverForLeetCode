impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut set1 = nums1.into_iter().collect::<std::collections::HashSet<i32>>();
        let mut set2 = nums2.into_iter().collect::<std::collections::HashSet<i32>>();
        let mut result = set1.intersection(&set2).map(|x| *x).collect::<Vec<i32>>();
        result.sort();
        result
    }
}