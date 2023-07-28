impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for i in 0..arr.len() {
            let v = arr[i];
            let mut count = 1;
            if let Some(x) = map.get(&(v - difference)) {
                count = *x + 1;
            }
            map.insert(v, count);
            if count > max {
                max = count;
            }
        }
        max
    }
}