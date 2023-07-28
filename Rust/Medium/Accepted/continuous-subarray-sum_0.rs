impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        for i in 0..nums.len() {
            sum += nums[i];
            if k != 0 {
                sum %= k;
            }
            if let Some(&last) = map.get(&sum) {
                if i as i32 - last > 1 {
                    return true;
                }
            } else {
                map.insert(sum, i as i32);
            }
        }
        false
    }
}