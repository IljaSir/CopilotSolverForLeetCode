impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let m = m as usize;
        let k = k as usize;
        let n = arr.len();
        let mut i = 0;
        let mut j = 0;
        while i + m * k <= n {
            j = i + m;
            while j + m <= n {
                if arr[i..i + m] == arr[j..j + m] {
                    j += m;
                } else {
                    break;
                }
            }
            if j - i == m * k {
                return true;
            }
            i += 1;
        }
        false
    }
}