impl Solution {
    pub fn min_impossible_or(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        for i in 0..nums.len() {
            if nums[i] <= ans {
                ans |= nums[i];
            } else {
                break;
            }
        }
        ans + 1
    }
}