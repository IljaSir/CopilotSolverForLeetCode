impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut ans = 0;
        for i in 0..32 {
            let mut cnt = 0;
            for j in 0..nums.len() {
                if (nums[j] >> i) & 1 == 1 {
                    cnt += 1;
                }
            }
            if cnt % 3 == 1 {
                ans |= 1 << i;
            }
        }
        ans
    }
}