impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut sum = 0;
        let mut set = std::collections::HashSet::new();
        let mut start = 0;
        for i in 0..nums.len() {
            while set.contains(&nums[i]) {
                set.remove(&nums[start]);
                sum -= nums[start];
                start += 1;
            }
            set.insert(nums[i]);
            sum += nums[i];
            max = max.max(sum);
        }
        max
    }
}