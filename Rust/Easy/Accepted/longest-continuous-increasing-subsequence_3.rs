impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if i == 0 || nums[i] > nums[i - 1] {
                count += 1;
            } else {
                count = 1;
            }
            max = max.max(count);
        }
        max
    }
}