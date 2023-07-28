impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for num in nums {
            let count = map.entry(num).or_insert(0);
            *count += 1;
            if *count > 1 {
                return num;
            }
        }
        0
    }
}