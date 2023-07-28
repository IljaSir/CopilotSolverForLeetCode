impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        if nums.len() == 0 {
            return 1;
        }
        let mut nums = nums;
        for i in 0..nums.len() {
            if nums[i] <= 0 {
                nums[i] = nums.len() as i32 + 1;
            }
        }
        for i in 0..nums.len() {
            let mut index = nums[i].abs() as usize;
            if index > nums.len() {
                continue;
            }
            index -= 1;
            nums[index] = -nums[index].abs();
        }
        for i in 0..nums.len() {
            if nums[i] > 0 {
                return (i + 1) as i32;
            }
        }
        (nums.len() + 1) as i32
    }
}