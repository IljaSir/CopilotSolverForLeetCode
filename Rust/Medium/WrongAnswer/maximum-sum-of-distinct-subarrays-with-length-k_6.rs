impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        use std::collections::HashSet;
        let mut set = HashSet::new();
        let mut sum = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            let x = nums[i];
            set.insert(x);
            sum += x;
            if i >= k as usize {
                sum -= nums[i - k as usize];
                set.remove(&nums[i - k as usize]);
            }
            if i >= k as usize - 1 && set.len() == k as usize {
                max = std::cmp::max(max, sum);
            }
        }
        max as i64
    }
}