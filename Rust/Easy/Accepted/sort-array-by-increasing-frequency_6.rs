impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = std::collections::HashMap::new();
        for n in nums {
            *count.entry(n).or_insert(0) += 1;
        }
        let mut v: Vec<_> = count.iter().collect();
        v.sort_by_key(|(k, v)| (*v, -**k));
        let mut result = Vec::new();
        for (k, v) in v {
            for _ in 0..*v {
                result.push(*k);
            }
        }
        result
    }
}