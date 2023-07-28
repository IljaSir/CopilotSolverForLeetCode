impl Solution {
    pub fn count_elements(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        for i in 1..nums.len() - 1 {
            if nums[i - 1] < nums[i] && nums[i] < nums[i + 1] {
                res += 1;
            }
        }
        res
    }
}