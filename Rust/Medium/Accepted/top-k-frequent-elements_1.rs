impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut v = map.into_iter().map(|(k, v)| (v, k)).collect::<Vec<(i32, i32)>>();
        v.sort_unstable_by(|a, b| b.cmp(a));
        v.into_iter().map(|(_, k)| k).take(k as usize).collect()
    }
}