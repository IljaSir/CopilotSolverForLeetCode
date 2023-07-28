impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i != j {
                    let prod = nums[i] * nums[j];
                    *map.entry(prod).or_insert(0) += 1;
                }
            }
        }
        for (_, v) in map {
            count += v * (v - 1) / 2 * 8;
        }
        count
    }
}