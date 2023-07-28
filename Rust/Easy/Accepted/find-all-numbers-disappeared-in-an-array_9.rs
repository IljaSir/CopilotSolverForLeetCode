impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = vec![];
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            let idx = (nums[i].abs() - 1) as usize;
            if nums[idx] > 0 {
                nums[idx] *= -1;
            }
            i += 1;
        }
        for i in 0..nums.len() {
            if nums[i] > 0 {
                result.push((i + 1) as i32);
            }
        }
        result
    }
}