impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        let mut res = -1;
        let mut l = 0;
        let mut r = 0;
        while r < n {
            sum += nums[r];
            while sum > x && l <= r {
                sum -= nums[l];
                l += 1;
            }
            if sum == x {
                res = res.max(r as i32 - l as i32 + 1);
            }
            r += 1;
        }
        if res == -1 {
            return -1;
        }
        (n as i32 - res) as i32
    }
}