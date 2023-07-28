impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        if nums.len() < 3 {
            return 0;
        }
        let mut count = 0;
        let mut i = 0;
        let mut j = 1;
        let mut k = 2;
        while k < nums.len() {
            if nums[k] - nums[j] == nums[j] - nums[i] {
                count += 1;
                k += 1;
                j += 1;
                i += 1;
            } else {
                i = j;
                j = k;
                k += 1;
            }
        }
        count
    }
}