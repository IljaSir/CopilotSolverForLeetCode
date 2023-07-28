impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        let mut q = std::collections::BTreeSet::new();
        for i in 0..nums.len() {
            sum += nums[i] as i64;
            if i as i32 >= k {
                sum -= nums[i - k as usize] as i64;
                q.remove(&(nums[i - k as usize], i as i32 - k));
            }
            q.insert((nums[i], i as i32));
            if i as i32 >= k - 1 {
                sum -= q.iter().next().unwrap().0 as i64;
            }
        }
        sum
    }
}