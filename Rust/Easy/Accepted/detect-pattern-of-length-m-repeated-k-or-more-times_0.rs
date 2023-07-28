impl Solution {
    pub fn contains_pattern(arr: Vec<i32>, m: i32, k: i32) -> bool {
        
        let n = arr.len();
        let m = m as usize;
        let k = k as usize;
        let mut i = 0;
        while i + m * k <= n {
            let mut j = i + m;
            let mut count = 1;
            while j + m <= n {
                let mut l = 0;
                while l < m && arr[i + l] == arr[j + l] {
                    l += 1;
                }
                if l == m {
                    count += 1;
                    if count == k {
                        return true;
                    }
                    j += m;
                } else {
                    break;
                }
            }
            i += 1;
        }
        false
    }
}