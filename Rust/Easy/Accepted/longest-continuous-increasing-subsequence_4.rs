impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        if nums.len() == 0 { return 0; }
        let mut max = 1;
        let mut current = 1;
        for i in 1..nums.len() {
            if nums[i] > nums[i - 1] {
                current += 1;
                max = std::cmp::max(max, current);
            } else {
                current = 1;
            }
        }
        max
    }
}