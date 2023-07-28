impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut last = nums[0];
        for i in 1..nums.len() {
            if nums[i] == last {
                ans += 1;
            } else {
                last = nums[i];
            }
        }
        ans
    }
}