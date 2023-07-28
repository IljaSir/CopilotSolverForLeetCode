impl Solution {
    pub fn max_rotate_function(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut sum = 0;
        let mut f = 0;
        for i in 0..n {
            sum += nums[i];
            f += i as i32 * nums[i];
        }
        let mut res = f;
        for i in (0..n).rev() {
            f += sum - n as i32 * nums[i];
            res = res.max(f);
        }
        res
    }
}