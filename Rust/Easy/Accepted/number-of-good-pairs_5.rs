impl Solution {
    pub fn num_identical_pairs(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if nums[i] == nums[j] && i < j {
                    count += 1;
                }
            }
        }
        count
    }
}