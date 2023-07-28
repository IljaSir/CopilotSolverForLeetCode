impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut cnt = 0;
        let mut map = std::collections::HashMap::new();
        for (i, &x) in nums.iter().enumerate() {
            if let Some(&y) = map.get(&(x-diff)) {
                cnt += y;
            }
            *map.entry(x).or_insert(0) += i as i32;
        }
        cnt
    }
}