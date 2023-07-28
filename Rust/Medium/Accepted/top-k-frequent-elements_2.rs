impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut vec = map.into_iter().collect::<Vec<(i32, i32)>>();
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        vec.iter().take(k as usize).map(|x| x.0).collect()
    }
}