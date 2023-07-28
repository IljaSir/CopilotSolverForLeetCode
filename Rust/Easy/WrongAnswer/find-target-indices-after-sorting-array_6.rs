impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut indices = vec![];
        
        for (i, n) in nums.iter().enumerate() {
            if *n == target {
                indices.push(i as i32);
            }
        }
        
        indices
    }
}