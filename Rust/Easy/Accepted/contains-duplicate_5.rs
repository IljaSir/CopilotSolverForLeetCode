impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        
        let mut set = std::collections::HashSet::new();
        for i in nums {
            if set.contains(&i) {
                return true;
            } else {
                set.insert(i);
            }
        }
        false
    }
}