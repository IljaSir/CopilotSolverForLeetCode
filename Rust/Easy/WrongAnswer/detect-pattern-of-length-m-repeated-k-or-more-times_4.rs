impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let m = m as usize;
        let k = k as usize;
        let n = arr.len();
        let mut count = 1;
        for i in 0..n - m {
            if arr[i..i + m] == arr[i + m..i + 2 * m] {
                count += 1;
                if count == k {
                    return true;
                }
            } else {
                count = 1;
            }
        }
        false
    }
}