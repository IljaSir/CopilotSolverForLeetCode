impl Solution {
    pub fn decompress_rl_elist(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ret = vec![];
        let mut i = 0;
        while i < nums.len() {
            let freq = nums[i];
            let val = nums[i + 1];
            for _ in 0..freq {
                ret.push(val);
            }
            i += 2;
        }
        ret
    }
}