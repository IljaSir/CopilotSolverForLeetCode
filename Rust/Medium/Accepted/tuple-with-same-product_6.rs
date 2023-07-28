impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        let mut m: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                *m.entry(nums[i] * nums[j]).or_insert(0) += 1;
            }
        }
        for (_, v) in m {
            cnt += v * (v - 1) / 2 * 8;
        }
        cnt
    }
}