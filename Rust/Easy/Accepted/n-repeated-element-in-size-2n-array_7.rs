impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let n = nums.len() / 2;
        let mut map = std::collections::HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
            if *map.get(&i).unwrap() == n {
                return i;
            }
        }
        0
    }
}