impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut ans = 0;
        while nums.iter().any(|&x| x > 0) {
            let mut carry = 0;
            for i in 0..nums.len() {
                if nums[i] & 1 == 1 {
                    nums[i] -= 1;
                    ans += 1;
                }
                nums[i] >>= 1;
                carry += nums[i];
            }
            if carry > 0 {
                ans += 1;
            }
        }
        ans
    }
}