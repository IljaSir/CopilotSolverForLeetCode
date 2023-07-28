impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut prev = nums[0];
        for i in 1..nums.len() {
            if nums[i] <= prev {
                ans += prev - nums[i] + 1;
                prev += 1;
            } else {
                prev = nums[i];
            }
        }
        ans
    }
}