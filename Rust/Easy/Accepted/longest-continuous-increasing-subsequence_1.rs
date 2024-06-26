impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        if nums.is_empty() {
            return 0;
        }
        let mut longest = 1;
        let mut current = 1;
        for i in 1..nums.len() {
            if nums[i] > nums[i - 1] {
                current += 1;
                longest = longest.max(current);
            } else {
                current = 1;
            }
        }
        longest
    }
}