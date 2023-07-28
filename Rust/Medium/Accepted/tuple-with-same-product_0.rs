impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                *map.entry(nums[i] * nums[j]).or_insert(0) += 1;
            }
        }
        let mut res = 0;
        for (_, v) in map {
            res += v * (v - 1) / 2 * 8;
        }
        res
    }
}