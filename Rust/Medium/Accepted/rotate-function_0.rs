impl Solution {
    pub fn max_rotate_function(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut sum = 0;
        let mut f = 0;
        for i in 0..n {
            sum += nums[i];
            f += i as i32 * nums[i];
        }
        let mut ans = f;
        for i in 1..n {
            f = f + sum - n as i32 * nums[n - i];
            ans = ans.max(f);
        }
        ans
    }
}