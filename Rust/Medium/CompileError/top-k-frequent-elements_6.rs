impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        let mut map = std::collections::HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut v = Vec::new();
        for (k, v) in map {
            v.push((k, v));
        }
        v.sort_by(|a, b| b.1.cmp(&a.1));
        v.iter().take(k as usize).map(|x| x.0).collect()
    }
}