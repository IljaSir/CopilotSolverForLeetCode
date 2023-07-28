impl Solution {
    pub fn array_change(nums: Vec<i32>, operations: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = nums;
        for op in operations {
            let (i, v) = (op[0] as usize, op[1]);
            result[i] = v;
        }
        result
    }
}