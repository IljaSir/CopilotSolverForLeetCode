impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut res = vec![];
        for i in 0..nums.len() {
            let mut index = (nums[i].abs() - 1) as usize;
            if nums[index] > 0 {
                nums[index] = -nums[index];
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