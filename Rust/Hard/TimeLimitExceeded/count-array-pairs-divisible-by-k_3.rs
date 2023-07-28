impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut pairs = 0;
        let mut count = vec![0; k as usize];
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                if (nums[i] * nums[j]) % k == 0 {
                    pairs += 1;
                }
            }
        }
        pairs
    }
}