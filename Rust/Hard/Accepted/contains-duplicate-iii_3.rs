impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && (j - i) <= index_diff as usize {
                if (nums[i] - nums[j]).abs() <= value_diff {
                    return true;
                }
                j += 1;
            }
            i += 1;
        }
        false
    }
}