impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        for (i, &num) in nums.iter().enumerate() {
            sum += num;
            if k != 0 {
                sum %= k;
            }
            if let Some(&prev) = map.get(&sum) {
                if i - prev >= 2 {
                    return true;
                }
            } else {
                map.insert(sum, i);
            }
        }
        false
    }
}