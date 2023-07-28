impl Solution {
    pub fn longest_subsequence(arr: Vec<i32>, difference: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 1;
        for i in 0 .. arr.len() {
            let x = arr[i];
            let y = map.get(&(x - difference)).unwrap_or(&0);
            let z = y + 1;
            map.insert(x, z);
            if z > max {
                max = z;
            }
        }
        max
    }
}