impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut sum = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        for i in 0..nums.len() {
            sum += nums[i];
            count += map.get(&(sum - k)).unwrap_or(&0);
            *map.entry(sum).or_insert(0) += 1;
        }
        count
    }
}