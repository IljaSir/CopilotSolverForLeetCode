impl Solution {
    pub fn find_error_nums(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut res = vec![0, 0];
        for i in 0..nums.len() {
            let index = (nums[i].abs() - 1) as usize;
            if nums[index] < 0 {
                res[0] = nums[i].abs();
            } else {
                nums[index] *= -1;
            }
        }
        for i in 0..nums.len() {
            if nums[i] > 0 {
                res[1] = (i + 1) as i32;
            }
        }
        res
    }
}