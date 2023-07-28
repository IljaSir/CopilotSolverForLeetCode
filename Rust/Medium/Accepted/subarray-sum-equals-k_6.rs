impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut sum = 0;
        let mut count = 0;
        let mut sum_map = std::collections::HashMap::new();
        sum_map.insert(0, 1);
        for num in nums {
            sum += num;
            count += sum_map.get(&(sum - k)).unwrap_or(&0);
            *sum_map.entry(sum).or_insert(0) += 1;
        }
        count
    }
}