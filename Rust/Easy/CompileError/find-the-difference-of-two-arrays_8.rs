impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![vec![],vec![]];
        let mut s1 = std::collections::HashSet::new();
        let mut s2 = std::collections::HashSet::new();
        for i in nums1 {
            s1.insert(i);
        }
        for i in nums2 {
            s2.insert(i);
        }
        for i in s1 {
            if !s2.contains(&i) {
                ans[0].push(i);
            }
        }
        for i in s2 {
            if !s1.contains(&i) {
                ans[1].push(i);
            }
        }
        ans
    }
}