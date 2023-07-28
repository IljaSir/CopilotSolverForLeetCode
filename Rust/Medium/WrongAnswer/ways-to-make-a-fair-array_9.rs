impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut sum_odd = 0;
        let mut sum_even = 0;
        let mut cnt = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                sum_even += nums[i];
            } else {
                sum_odd += nums[i];
            }
        }
        for i in 0..nums.len() {
            if i % 2 == 0 {
                sum_even -= nums[i];
            } else {
                sum_odd -= nums[i];
            }
            if sum_odd + sum == sum_even {
                cnt += 1;
            }
            if i % 2 == 0 {
                sum += nums[i];
            }
        }
        cnt
    }
}