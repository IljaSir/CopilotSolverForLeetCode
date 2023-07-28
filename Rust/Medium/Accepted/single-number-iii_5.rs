impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        nums.sort();
        let mut result = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            if i == nums.len() - 1 || nums[i] != nums[i + 1] {
                result.push(nums[i]);
            } else {
                i += 1;
            }
            i += 1;
        }
        result
    }
}