impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..1 << nums.len() {
            let mut cur = 0;
            for j in 0..nums.len() {
                if (i >> j) & 1 == 1 {
                    cur ^= nums[j];
                }
            }
            res += cur;
        }
        res
    }
}