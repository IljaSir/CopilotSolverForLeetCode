impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for n in nums {
            if let Some(v) = map.get_mut(&n) {
                if *v > 0 {
                    *v -= 1;
                    count += 1;
                } else {
                    *map.entry(k-n).or_insert(0) += 1;
                }
            } else {
                *map.entry(k-n).or_insert(0) += 1;
            }
        }
        count
    }
}