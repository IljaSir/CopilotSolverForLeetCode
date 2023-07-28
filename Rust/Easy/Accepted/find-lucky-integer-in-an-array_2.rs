impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for n in arr {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut ans = -1;
        for (k, v) in map {
            if k == v {
                ans = ans.max(k);
            }
        }
        ans
    }
}