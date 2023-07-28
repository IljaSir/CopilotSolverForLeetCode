impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        let mut sum = 0;
        let mut max = 0;
        let mut left = 0;
        for right in 0..nums.len() {
            while set.contains(&nums[right]) {
                set.remove(&nums[left]);
                sum -= nums[left];
                left += 1;
            }
            set.insert(nums[right]);
            sum += nums[right];
            max = std::cmp::max(max, sum);
        }
        max
    }
}