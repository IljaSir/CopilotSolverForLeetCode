impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        let mut count = 0;
        let mut i = 0;
        while i < nums.len() - 2 {
            let mut j = i + 2;
            let diff = nums[i + 1] - nums[i];
            while j < nums.len() && nums[j] - nums[j - 1] == diff {
                j += 1;
            }
            count += j - i - 2;
            i = j - 1;
        }
        count
    }
}