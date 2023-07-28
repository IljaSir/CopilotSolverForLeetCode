impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        if nums.len() < 2 { return false; }
        let mut sum = 0;
        let mut mod_map = std::collections::HashMap::new();
        mod_map.insert(0, -1);
        for i in 0..nums.len() {
            sum += nums[i];
            if k != 0 {
                sum %= k;
            }
            if let Some(&prev) = mod_map.get(&sum) {
                if i - prev > 1 {
                    return true;
                }
            } else {
                mod_map.insert(sum, i as i32);
            }
        }
        false
    }
}