impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut indices: Vec<i32> = vec![];
        let mut nums = nums;
        nums.sort();
        for i in 0..nums.len() {
            if nums[i] == target {
                indices.push(i as i32);
            }
        }
        return indices;
    }
}