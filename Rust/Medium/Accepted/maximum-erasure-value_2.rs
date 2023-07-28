impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut map = std::collections::HashMap::new();
        let mut i = 0;
        for j in 0..nums.len() {
            if let Some(&k) = map.get(&nums[j]) {
                while i <= k {
                    sum -= nums[i];
                    map.remove(&nums[i]);
                    i += 1;
                }
            }
            map.insert(nums[j], j);
            sum += nums[j];
            max = max.max(sum);
        }
        max
    }
}