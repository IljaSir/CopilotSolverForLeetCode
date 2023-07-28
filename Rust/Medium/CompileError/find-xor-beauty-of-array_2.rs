impl Solution {
    pub fn xor_beauty(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 0..32 {
            let mut cnt = 0;
            for &x in &nums {
                if x & (1 << i) != 0 {
                    cnt += 1;
                }
            }
            ans |= (cnt * (nums.len() - cnt) % 2) << i;
        }
        ans
    }
}