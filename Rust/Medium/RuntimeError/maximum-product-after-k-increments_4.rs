impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let n = nums.len();
        let k = k as usize;
        for i in 0..k {
            ans *= nums[n - 1 - i];
            ans %= 1000000007;
        }
        for i in 0..k {
            ans *= nums[i];
            ans %= 1000000007;
        }
        ans as i32
    }
}