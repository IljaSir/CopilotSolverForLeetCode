impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        let mut map = std::collections::HashMap::new();
        for &num in nums.iter() {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut vec = Vec::new();
        for (k, v) in map.into_iter() {
            vec.push((k, v));
        }
        vec.sort_by_key(|x| x.1);
        vec.iter().rev().take(k as usize).map(|x| x.0).collect()
    }
}