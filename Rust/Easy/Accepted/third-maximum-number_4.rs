impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut set: std::collections::HashSet<i32> = std::collections::HashSet::new();
        for i in nums {
            set.insert(i);
        }
        let mut vec: Vec<i32> = set.into_iter().collect();
        vec.sort();
        if vec.len() < 3 {
            return vec[vec.len() - 1];
        }
        vec[vec.len() - 3]
    }
}