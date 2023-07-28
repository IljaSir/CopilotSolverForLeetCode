impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let product = nums[i] * nums[j];
                *map.entry(product).or_insert(0) += 1;
            }
        }
        for (_, v) in map {
            ans += v * (v-1) / 2 * 8;
        }
        ans
    }
}