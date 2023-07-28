impl Solution {
    pub fn min_max_game(nums: Vec<i32>) -> i32 {
        
        let mut res = nums[0];
        for i in 1..nums.len() {
            res = res.min(nums[i]).max(nums[i]);
        }
        res
    }
}