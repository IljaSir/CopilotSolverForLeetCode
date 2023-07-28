impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for i in 0..arr.len() {
            let num = arr[i];
            let prev = num - difference;
            let count = map.get(&prev).unwrap_or(&0) + 1;
            map.insert(num, count);
            max = std::cmp::max(max, count);
        }
        max
    }
}