impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 1;
        for n in nums {
            if n == i {
                i += 1;
            }
        }
        i
    }
}