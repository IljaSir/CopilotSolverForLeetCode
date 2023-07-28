impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut set = std::collections::HashSet::new();
        for i in 0..nums.len() {
            while set.contains(&nums[i]) {
                set.remove(&nums[i - k as usize]);
                sum -= nums[i - k as usize] as i64;
            }
            set.insert(nums[i]);
            sum += nums[i] as i64;
            max = std::cmp::max(max, sum);
        }
        max
    }
}