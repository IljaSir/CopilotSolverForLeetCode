impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        let mut sum = 0;
        let mut res = -1;
        let mut n = nums.len();
        while r < n {
            sum += nums[r];
            while sum > x && l <= r {
                sum -= nums[l];
                l += 1;
            }
            if sum == x {
                res = res.max((r - l + 1) as i32);
            }
            r += 1;
        }
        if res == -1 {
            return res;
        }
        return (n as i32) - res;
    }
}