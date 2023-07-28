impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let mut even = 0;
        let mut odd = 0;
        let mut res = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        let mut left_even = 0;
        let mut left_odd = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                even -= nums[i];
                if left_odd + even == left_even + odd {
                    res += 1;
                }
                left_even += nums[i];
            } else {
                odd -= nums[i];
                if left_odd + even == left_even + odd {
                    res += 1;
                }
                left_odd += nums[i];
            }
        }
        res
    }
}