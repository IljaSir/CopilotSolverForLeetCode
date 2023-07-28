impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut list: Vec<_> = map.into_iter().collect();
        list.sort_by(|a, b| {
            if a.1 == b.1 {
                b.0.cmp(&a.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        let mut result = Vec::new();
        for (k, v) in list {
            for _ in 0..v {
                result.push(k);
            }
        }
        result
    }
}