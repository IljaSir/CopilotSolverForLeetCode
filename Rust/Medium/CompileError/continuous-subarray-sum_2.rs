impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let n = nums.len();
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        for i in 0..n {
            sum += nums[i];
            if k != 0 {
                sum %= k;
            }
            if let Some(&prev) = map.get(&sum) {
                if i - prev > 1 {
                    return true;
                }
            } else {
                map.insert(sum, i as i32);
            }
        }
        false
    }
}