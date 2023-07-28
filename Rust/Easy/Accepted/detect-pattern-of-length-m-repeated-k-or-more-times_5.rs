impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let m = m as usize;
        let k = k as usize;
        let n = arr.len();
        for i in 0..n - m {
            let mut cnt = 1;
            for j in i + m..n - m + 1 {
                if arr[j..j + m] == arr[i..i + m] {
                    cnt += 1;
                } else {
                    break;
                }
            }
            if cnt >= k {
                return true;
            }
        }
        false
    }
}