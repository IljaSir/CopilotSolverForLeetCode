impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut freq = std::collections::HashMap::new();
        for n in nums.iter() {
            *freq.entry(n).or_insert(0) += 1;
        }
        let mut freq = freq.into_iter().collect::<Vec<_>>();
        freq.sort_by_key(|&(_, v)| v);
        let mut result = Vec::new();
        for (k, v) in freq {
            for _ in 0..v {
                result.push(*k);
            }
        }
        result
    }
}