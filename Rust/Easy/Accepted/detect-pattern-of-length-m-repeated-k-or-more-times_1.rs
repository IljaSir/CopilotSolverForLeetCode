impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let m = m as usize;
        let k = k as usize;
        let mut i = 0;
        while i + m * k <= arr.len() {
            let mut j = 1;
            while j < k && arr[i..i + m] == arr[i + j * m..i + (j + 1) * m] {
                j += 1;
            }
            if j == k {
                return true;
            }
            i += 1;
        }
        false
    }
}