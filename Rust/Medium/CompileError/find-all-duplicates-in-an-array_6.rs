impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut result = Vec::new();
        let mut nums = nums;
        for num in nums {
            let index = (num.abs() - 1) as usize;
            if nums[index] < 0 {
                result.push(num.abs());
            }
            nums[index] *= -1;
        }
        result
    }
}