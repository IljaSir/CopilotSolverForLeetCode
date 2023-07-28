impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        let mut res = vec![];
        for i in 0..nums.len() {
            let index = nums[i].abs() as usize - 1;
            if nums[index] < 0 {
                res.push(index as i32 + 1);
            } else {
                nums[index] *= -1;
            }
        }
        res
    }
}