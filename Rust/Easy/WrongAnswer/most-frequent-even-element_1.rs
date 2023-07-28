impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for &n in nums.iter() {
            if n % 2 == 0 {
                *map.entry(n).or_insert(0) += 1;
            }
        }
        let mut candidates = map.iter().map(|(&k, &v)| (k, v)).collect::<Vec<_>>();
        candidates.sort_by_key(|&(_, v)| std::cmp::Reverse(v));
        if candidates.len() == 0 {
            return -1;
        }
        candidates[0].0
    }
}