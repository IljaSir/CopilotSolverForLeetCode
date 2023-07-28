impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = nums.len() as i32;
        let mut i = 0;
        let mut j = 0;
        while i < nums.len() {
            while j < nums.len() && nums[j] - nums[i] < nums.len() as i32 {
                j += 1;
            }
            ans = ans.min((nums.len() - (j - i)) as i32);
            i += 1;
        }
        ans
    }
}