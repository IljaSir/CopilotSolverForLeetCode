impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                even = even.max(odd + nums[i] as i64);
            } else {
                odd = odd.max(even - nums[i] as i64);
            }
        }
        even
    }
}