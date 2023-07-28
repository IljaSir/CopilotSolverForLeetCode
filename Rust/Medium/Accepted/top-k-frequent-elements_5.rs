impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        let mut freq = std::collections::HashMap::new();
        for num in nums {
            *freq.entry(num).or_insert(0) += 1;
        }
        let mut freq = freq.into_iter().collect::<Vec<_>>();
        freq.sort_by(|(_, a), (_, b)| b.cmp(a));
        freq.into_iter().map(|(k, _)| k).take(k as usize).collect()
    }
}