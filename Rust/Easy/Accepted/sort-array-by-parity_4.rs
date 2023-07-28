impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        for i in nums {
            if i % 2 == 0 {
                result.insert(0, i);
            } else {
                result.push(i);
            }
        }
        result
    }
}