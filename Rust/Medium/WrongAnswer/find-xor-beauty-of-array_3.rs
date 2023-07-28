impl Solution {
    pub fn xor_beauty(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..32 {
            let mut ones = 0;
            let mut zeros = 0;
            for &n in &nums {
                if n & (1 << i) == 0 {
                    zeros += 1;
                } else {
                    ones += 1;
                }
            }
            res |= (ones * zeros) & 1 << i;
        }
        res
    }
}