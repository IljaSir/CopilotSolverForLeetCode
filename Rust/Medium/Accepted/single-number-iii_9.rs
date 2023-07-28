impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut result = vec![];
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[i] == nums[j] {
                j += 1;
            }
            if j - i == 1 {
                result.push(nums[i]);
            }
            i = j;
        }
        result
    }
}