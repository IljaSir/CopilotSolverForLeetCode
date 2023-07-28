impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut indices = Vec::new();
        for i in 0..nums.len() {
            if nums[i] == key {
                indices.push(i as i32);
            }
        }
        let mut result = Vec::new();
        let mut j = 0;
        for i in 0..nums.len() {
            while j < indices.len() && indices[j] - i as i32 <= k {
                j += 1;
            }
            if j < indices.len() && indices[j] - i as i32 <= k {
                result.push(i as i32);
            }
        }
        result
    }
}