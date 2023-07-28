impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut xor = 0;
        for num in nums.iter() {
            xor ^= num;
        }
        let mask = xor & (xor - 1) ^ xor;
        let mut ans = vec![0, 0];
        for num in nums.iter() {
            if (num & mask) == 0 {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        ans
    }
}