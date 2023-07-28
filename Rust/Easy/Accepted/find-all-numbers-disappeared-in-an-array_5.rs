impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut nums = nums;
        for i in 0..nums.len() {
            let index = (nums[i].abs() - 1) as usize;
            if nums[index] > 0 {
                nums[index] *= -1;
            }
        }
        for i in 0..nums.len() {
            if nums[i] > 0 {
                res.push((i + 1) as i32);
            }
        }
        res
    }
}