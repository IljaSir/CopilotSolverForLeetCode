impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut count = 0;
        for i in nums.iter() {
            sum += i;
            if sum == k {
                count += 1;
            }
            if let Some(&v) = map.get(&(sum - k)) {
                count += v;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        count
    }
}