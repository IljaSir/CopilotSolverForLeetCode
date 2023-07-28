impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for n in nums {
            match map.get_mut(&n) {
                Some(v) => *v += 1,
                None => {
                    map.insert(n, 1);
                }
            }
        }
        let mut vec: Vec<(i32, i32)> = map.iter().map(|(k, v)| (*k, *v)).collect();
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        vec.iter().map(|(k, _)| *k).take(k as usize).collect()
    }
}