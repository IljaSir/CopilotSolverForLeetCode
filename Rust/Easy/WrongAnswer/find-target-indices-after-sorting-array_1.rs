impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut sorted = nums.clone();
        sorted.sort();
        for i in 0..nums.len() {
            if nums[i] == target {
                result.push(sorted.iter().position(|&x| x == target).unwrap() as i32);
            }
        }
        result
    }
}