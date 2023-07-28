impl Solution {
    pub fn find_error_nums(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut dup = 0;
        let mut miss = 0;
        for i in 0..nums.len() {
            let idx = (nums[i].abs() - 1) as usize;
            if nums[idx] < 0 {
                dup = nums[i].abs();
            } else {
                nums[idx] *= -1;
            }
        }
        for i in 0..nums.len() {
            if nums[i] > 0 {
                miss = (i + 1) as i32;
            }
        }
        vec![dup, miss]
    }
}