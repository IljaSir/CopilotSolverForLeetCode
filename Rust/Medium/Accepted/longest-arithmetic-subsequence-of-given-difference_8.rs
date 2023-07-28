impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut seq = std::collections::HashMap::new();
        let mut max_len = 0;
        for i in 0..arr.len() {
            let prev = arr[i] - difference;
            let prev_len = seq.get(&prev).unwrap_or(&0);
            let cur_len = prev_len + 1;
            seq.insert(arr[i], cur_len);
            max_len = max_len.max(cur_len);
        }
        max_len
    }
}