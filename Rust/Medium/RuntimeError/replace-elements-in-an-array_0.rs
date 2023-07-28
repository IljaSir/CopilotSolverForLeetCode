impl Solution {
    pub fn array_change(nums: Vec<i32>, operations: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut nums = nums;
        for operation in operations {
            nums[operation[0] as usize - 1] = operation[1];
        }
        nums
    }
}