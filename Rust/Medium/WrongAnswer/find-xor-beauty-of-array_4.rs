impl Solution {
    pub fn xor_beauty(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 0..32 {
            let mut cnt = 0;
            for num in nums.iter() {
                let b = (num >> i) & 1;
                if b == 1 {
                    cnt += 1;
                }
            }
            ans ^= cnt & 1;
        }
        ans
    }
}