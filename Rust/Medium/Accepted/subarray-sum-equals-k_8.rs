impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut prefix = 0;
        let mut map = std::collections::HashMap::new();
        let mut count = 0;
        map.insert(0, 1);
        for num in nums {
            prefix += num;
            if let Some(v) = map.get(&(prefix - k)) {
                count += v;
            }
            *map.entry(prefix).or_insert(0) += 1;
        }
        count
    }
}