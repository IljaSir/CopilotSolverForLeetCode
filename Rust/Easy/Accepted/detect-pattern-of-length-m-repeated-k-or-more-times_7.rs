impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let (m, k) = (m as usize, k as usize);
        let mut i = 0;
        while i + m * k <= arr.len() {
            let mut j = i + m;
            while j + m <= arr.len() {
                if arr[i..i+m] == arr[j..j+m] {
                    j += m;
                } else {
                    break;
                }
            }
            if j == i + k * m {
                return true;
            }
            i += 1;
        }
        false
    }
}