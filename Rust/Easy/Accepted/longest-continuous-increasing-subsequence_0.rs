impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        if nums.len() == 0 {
            return 0;
        }
        let mut max = 1;
        let mut cur = 1;
        for i in 1..nums.len() {
            if nums[i] > nums[i-1] {
                cur += 1;
            } else {
                cur = 1;
            }
            max = max.max(cur);
        }
        max
    }
}