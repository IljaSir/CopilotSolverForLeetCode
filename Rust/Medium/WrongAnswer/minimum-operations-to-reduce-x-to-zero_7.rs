impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let mut sum = 0;
        let mut l = 0;
        let mut r = nums.len() - 1;
        let mut res = -1;
        while l <= r {
            sum += nums[l];
            l += 1;
            if sum == x {
                res = l as i32;
                break;
            }
        }
        sum = 0;
        while r >= l {
            sum += nums[r];
            r -= 1;
            if sum == x {
                res = (nums.len() - r - 1) as i32;
                break;
            }
        }
        while l <= r {
            sum -= nums[l];
            l += 1;
            while sum < x && l <= r {
                sum += nums[r];
                r -= 1;
            }
            if sum == x {
                res = res.max((l + nums.len() - r - 1) as i32);
            }
        }
        if res == -1 {
            return -1;
        }
        (nums.len() as i32 - res)
    }
}