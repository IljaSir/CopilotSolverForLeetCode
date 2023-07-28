impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let mut set = std::collections::HashSet::new();
        let mut sum = 0;
        let mut i = 0;
        let mut j = 0;
        let mut ans = 0;
        while j < nums.len() {
            if set.len() == k {
                sum -= nums[i] as i64;
                set.remove(&nums[i]);
                i += 1;
            }
            if !set.contains(&nums[j]) {
                set.insert(nums[j]);
                sum += nums[j] as i64;
                ans = ans.max(sum);
                j += 1;
            } else {
                j += 1;
            }
        }
        ans
    }
}