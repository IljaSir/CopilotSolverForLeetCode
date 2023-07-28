impl Solution {
    pub fn decompress_rl_elist(nums: Vec<i32>) -> Vec<i32> {
        
        let mut v = Vec::new();
        for i in (0..nums.len()).step_by(2) {
            let (f, v) = (nums[i], nums[i + 1]);
            for _ in 0..f {
                v.push(v);
            }
        }
        v
    }
}