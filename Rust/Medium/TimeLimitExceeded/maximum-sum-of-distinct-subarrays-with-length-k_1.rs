impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut set = std::collections::HashSet::new();
        let mut sum = 0;
        let mut ans = 0;
        let k = k as usize;
        for i in 0..nums.len() {
            if i >= k {
                set.remove(&nums[i - k]);
                sum -= nums[i - k];
            }
            while set.contains(&nums[i]) {
                set.remove(&nums[i - k]);
                sum -= nums[i - k];
            }
            set.insert(nums[i]);
            sum += nums[i];
            ans = std::cmp::max(ans, sum);
        }
        ans as i64
    }
}