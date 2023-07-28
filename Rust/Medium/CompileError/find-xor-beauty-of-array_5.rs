impl Solution {
    pub fn xor_beauty(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut count = vec![0; 31];
        let mut mask = 1;
        for i in 0..31 {
            for &num in &nums {
                if num & mask != 0 {
                    count[i] += 1;
                }
            }
            mask <<= 1;
        }
        for i in 0..31 {
            res |= (count[i] * (nums.len() - count[i]) % 2) << i;
        }
        res
    }
}