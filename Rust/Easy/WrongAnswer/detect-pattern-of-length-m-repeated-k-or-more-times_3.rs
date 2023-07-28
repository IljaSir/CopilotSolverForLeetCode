impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let m = m as usize;
        let k = k as usize;
        let mut i = 0;
        while i + m * k <= arr.len() {
            let mut j = 0;
            while j + m <= arr.len() {
                if arr[i..i+m] == arr[j..j+m] {
                    i += m;
                    j += m;
                } else {
                    break;
                }
            }
            if j == arr.len() {
                return true;
            }
            i = j;
        }
        false
    }
}