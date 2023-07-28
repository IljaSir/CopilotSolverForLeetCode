impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        let mut res = Vec::new();
        for i in 0..nums.len() {
            let idx = nums[i].abs() as usize - 1;
            if nums[idx] < 0 {
                res.push(nums[idx].abs());
            } else {
                nums[idx] *= -1;
            }
        }
        res
    }
}