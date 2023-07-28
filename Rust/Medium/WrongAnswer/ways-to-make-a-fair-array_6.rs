impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut left = 0;
        let mut right = nums.iter().sum::<i32>();
        for i in 0..nums.len() {
            if i % 2 == 0 {
                left += nums[i];
            } else {
                right -= nums[i];
            }
            if left == right {
                ans += 1;
            }
        }
        ans
    }
}