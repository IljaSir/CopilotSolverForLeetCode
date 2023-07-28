impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for num in nums {
            if !set.insert(num) {
                return num;
            }
        }
        0
    }
}