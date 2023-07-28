impl Solution {
    pub fn count_elements(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut set = std::collections::HashSet::new();
        for i in 0..nums.len() {
            set.insert(nums[i]);
        }
        for i in 0..nums.len() {
            if set.contains(&(nums[i] - 1)) && set.contains(&(nums[i] + 1)) {
                count += 1;
            }
        }
        count
    }
}