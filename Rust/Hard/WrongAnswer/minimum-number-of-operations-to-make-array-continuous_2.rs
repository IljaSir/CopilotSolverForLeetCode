impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut ans = nums.len() as i32;
        let mut l = 0;
        let mut r = 0;
        while r < nums.len() {
            while r < nums.len() && nums[r] - nums[l] < nums.len() as i32 {
                r += 1;
            }
            ans = ans.min((nums.len() - (r - l)) as i32);
            l += 1;
        }
        ans
    }
}