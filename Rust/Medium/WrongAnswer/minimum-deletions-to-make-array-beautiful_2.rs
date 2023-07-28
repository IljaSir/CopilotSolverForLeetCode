impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut prev = nums[0];
        for i in 1..nums.len() {
            if nums[i] == prev {
                count += 1;
            } else {
                prev = nums[i];
            }
        }
        count
    }
}