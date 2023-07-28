impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut map = std::collections::HashMap::new();
        let mut start = 0;
        for (i, n) in nums.iter().enumerate() {
            if let Some(&index) = map.get(n) {
                while start <= index {
                    sum -= nums[start];
                    map.remove(&nums[start]);
                    start += 1;
                }
            }
            map.insert(*n, i);
            sum += *n;
            max = std::cmp::max(max, sum);
        }
        max
    }
}