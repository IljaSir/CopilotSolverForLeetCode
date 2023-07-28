impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for &x in arr.iter() {
            let l = map.get(&(x - difference)).unwrap_or(&0) + 1;
            map.insert(x, l);
            res = res.max(l);
        }
        res
    }
}