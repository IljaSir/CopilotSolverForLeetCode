impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut a = std::collections::HashMap::new();
        for n in nums {
            let c = a.entry(n).or_insert(0);
            *c += 1;
            if *c == nums.len() / 2 {
                return n;
            }
        }
        0
    }
}