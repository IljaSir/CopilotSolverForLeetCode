impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut dp = std::collections::HashMap::new();
        let mut max = 1;
        for i in arr {
            let count = dp.entry(i).or_insert(0);
            *count = dp.get(&(i - difference)).unwrap_or(&0) + 1;
            max = max.max(*count);
        }
        max
    }
}