impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in nums {
            if let Some(n) = map.get_mut(&i) {
                *n += 1;
                if *n == nums.len() / 2 {
                    return i;
                }
            } else {
                map.insert(i, 1);
            }
        }
        0
    }
}