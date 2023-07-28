impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut s1 = nums1.into_iter().collect::<std::collections::HashSet<i32>>();
        let mut s2 = nums2.into_iter().collect::<std::collections::HashSet<i32>>();
        let mut s = s1.union(&s2).cloned().collect::<Vec<i32>>();
        s.sort();
        s.into_iter().fold(0, |acc, x| acc * 10 + x)
    }
}