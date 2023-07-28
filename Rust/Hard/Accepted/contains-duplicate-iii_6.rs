impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut nums = nums;
        for i in 0..nums.len() {
            for j in (i + 1)..nums.len() {
                if (j - i) as i32 <= index_diff && (nums[i] - nums[j]).abs() <= value_diff {
                    return true;
                }
            }
        }
        false
    }
}