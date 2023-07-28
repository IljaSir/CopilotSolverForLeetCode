impl Solution {
    pub fn min_patches(nums: Vec<i32>, n: i32) -> i32 {
        
        let mut res = 0;
        let mut i = 0;
        let mut x = 1;
        while x <= n {
            if i < nums.len() && nums[i] <= x {
                x += nums[i];
                i += 1;
            } else {
                x *= 2;
                res += 1;
            }
        }
        res
    }
}