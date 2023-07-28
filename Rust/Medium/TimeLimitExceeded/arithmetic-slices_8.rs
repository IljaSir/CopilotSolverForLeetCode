impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        let mut count = 0;
        let mut i = 0;
        while i < nums.len() - 2 {
            let mut j = i + 2;
            while j < nums.len() {
                if nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2] {
                    count += 1;
                    j += 1;
                } else {
                    break;
                }
            }
            i += 1;
        }
        count
    }
}