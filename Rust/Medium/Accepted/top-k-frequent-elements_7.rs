impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for n in nums {
            let v = map.entry(n).or_insert(0);
            *v += 1;
        }
        let mut v = map.into_iter().collect::<Vec<(i32, i32)>>();
        v.sort_by(|a, b| b.1.cmp(&a.1));
        v.into_iter().take(k as usize).map(|(k, _)| k).collect()
    }
}