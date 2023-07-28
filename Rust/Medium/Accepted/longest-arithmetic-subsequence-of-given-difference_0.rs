impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut dp = std::collections::HashMap::new();
        let mut ans = 1;
        for &x in arr.iter() {
            let y = dp.get(&(x - difference)).unwrap_or(&0) + 1;
            dp.insert(x, y);
            ans = std::cmp::max(ans, y);
        }
        ans
    }
}