impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        
        let mut s = std::collections::HashSet::new();
        for x in nums {
            if s.contains(&x) {
                return true;
            }
            s.insert(x);
        }
        false
    }
}