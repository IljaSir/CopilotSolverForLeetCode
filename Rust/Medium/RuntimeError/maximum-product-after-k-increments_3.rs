impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let n = nums.len();
        for i in 0..k as usize {
            ans *= nums[i];
            ans %= 1_000_000_007;
        }
        for i in 0..k as usize {
            ans *= nums[n - 1 - i];
            ans %= 1_000_000_007;
        }
        ans
    }
}