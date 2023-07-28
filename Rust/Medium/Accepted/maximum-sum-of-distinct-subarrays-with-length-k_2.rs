impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut set = std::collections::HashSet::new();
        let mut i = 0;
        for j in 0..nums.len() {
            while set.contains(&nums[j]) {
                set.remove(&nums[i]);
                sum -= nums[i] as i64;
                i += 1;
            }
            sum += nums[j] as i64;
            set.insert(nums[j]);
            if (j - i + 1) as i32 == k {
                if sum > max {
                    max = sum;
                }
                set.remove(&nums[i]);
                sum -= nums[i] as i64;
                i += 1;
            }
        }
        max
    }
}