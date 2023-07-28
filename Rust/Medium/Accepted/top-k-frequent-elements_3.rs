impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for i in nums {
            let count = map.entry(i).or_insert(0);
            *count += 1;
        }
        let mut vec = Vec::new();
        for (k, v) in map {
            vec.push((k, v));
        }
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        let mut ans = Vec::new();
        for i in 0..k {
            ans.push(vec[i as usize].0);
        }
        ans
    }
}