impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let sum = nums[i] * nums[j];
                *map.entry(sum).or_insert(0) += 1;
            }
        }
        let mut ans = 0;
        for (_, v) in map {
            ans += v * (v - 1);
        }
        ans * 8
    }
}