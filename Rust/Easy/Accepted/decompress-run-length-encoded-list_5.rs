impl Solution {
    pub fn decompress_rl_elist(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res: Vec<i32> = Vec::new();
        for i in 0..nums.len() / 2 {
            for _ in 0..nums[i * 2] {
                res.push(nums[i * 2 + 1]);
            }
        }
        res
    }
}