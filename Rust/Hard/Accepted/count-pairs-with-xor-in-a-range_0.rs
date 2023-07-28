impl Solution {
    pub fn count_pairs(nums: Vec<i32>, low: i32, high: i32) -> i32 {
        
        let mut res = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let xor = nums[i] ^ nums[j];
                if xor >= low && xor <= high {
                    res += 1;
                }
            }
        }
        res
    }
}