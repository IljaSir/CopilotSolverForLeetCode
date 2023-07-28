impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut n = 1;
        for i in 0..nums.len() {
            if nums[i] > 0 && nums[i] == n {
                n += 1;
            }
        }
        n
    }
}