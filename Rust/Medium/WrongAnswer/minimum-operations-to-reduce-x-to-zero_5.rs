impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        let mut res = -1;
        let mut i = 0;
        let mut j = 0;
        while i < n {
            sum += nums[i];
            while sum > x && j <= i {
                sum -= nums[j];
                j += 1;
            }
            if sum == x {
                res = res.max(i as i32 - j as i32 + 1);
            }
            i += 1;
        }
        if res == -1 {
            -1
        } else {
            n as i32 - res
        }
    }
}