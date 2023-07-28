impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut m = std::collections::HashMap::new();
        let mut max = 1;
        for i in 0..arr.len() {
            let n = arr[i];
            let prev = n - difference;
            let prev_len = *m.get(&prev).unwrap_or(&0);
            let len = prev_len + 1;
            m.insert(n, len);
            if len > max {
                max = len;
            }
        }
        max
    }
}