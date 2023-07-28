impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 1;
        let n = nums.len();
        for i in 0..k as usize {
            res *= nums[i];
            res %= 1_000_000_007;
        }
        for i in 0..k as usize {
            res *= nums[n - 1 - i];
            res %= 1_000_000_007;
        }
        res as i32
    }
}