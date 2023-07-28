impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut sum = 0;
        let mut seen = std::collections::HashMap::new();
        for (i, &n) in nums.iter().enumerate() {
            sum += n;
            if k != 0 {
                sum %= k;
            }
            if let Some(&j) = seen.get(&sum) {
                if i - j > 1 {
                    return true;
                }
            } else {
                seen.insert(sum, i);
            }
        }
        false
    }
}