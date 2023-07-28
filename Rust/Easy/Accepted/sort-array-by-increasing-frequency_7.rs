impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for n in nums {
            let count = map.entry(n).or_insert(0);
            *count += 1;
        }
        let mut nums: Vec<_> = map.into_iter().collect();
        nums.sort_by(|a, b| a.1.cmp(&b.1).then_with(|| b.0.cmp(&a.0)));
        let mut res = Vec::new();
        for (n, count) in nums {
            for _ in 0..count {
                res.push(n);
            }
        }
        res
    }
}