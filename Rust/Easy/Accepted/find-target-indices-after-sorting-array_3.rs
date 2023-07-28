impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut indices = Vec::new();
        let mut nums = nums;
        nums.sort();
        for (i, &num) in nums.iter().enumerate() {
            if num == target {
                indices.push(i as i32);
            }
        }
        indices
    }
}