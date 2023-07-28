impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut set = std::collections::HashSet::new();
        let mut i = 0;
        for j in 0..nums.len() {
            while set.contains(&nums[j]) {
                set.remove(&nums[i]);
                sum -= nums[i];
                i += 1;
            }
            set.insert(nums[j]);
            sum += nums[j];
            max = max.max(sum);
        }
        max
    }
}