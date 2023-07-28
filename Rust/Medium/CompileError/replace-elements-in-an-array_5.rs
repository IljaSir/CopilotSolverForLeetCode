impl Solution {
    pub fn array_change(nums: Vec<i32>, operations: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = nums;
        for (x, y) in operations {
            ans[(x - 1) as usize] = y;
        }
        ans
    }
}