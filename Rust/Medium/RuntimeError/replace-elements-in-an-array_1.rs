impl Solution {
    pub fn array_change(nums: Vec<i32>, operations: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut nums = nums;
        for op in operations {
            let idx = op[0] as usize;
            let num = op[1];
            nums[idx] = num;
        }
        nums
    }
}