impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut dp = std::collections::HashMap::new();
        let mut ans = 1;
        for x in arr {
            let v = dp.entry(x - difference).or_insert(0);
            *v += 1;
            ans = ans.max(*v);
        }
        ans
    }
}