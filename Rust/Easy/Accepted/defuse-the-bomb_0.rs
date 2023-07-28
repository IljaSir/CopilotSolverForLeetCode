impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = code.len();
        let mut res = vec![0; n];
        if k == 0 {
            return res;
        }
        if k > 0 {
            for i in 0..n {
                for j in 1..=k as usize {
                    res[i] += code[(i + j) % n];
                }
            }
        } else {
            for i in 0..n {
                for j in 1..=k.abs() as usize {
                    res[i] += code[(n + i - j) % n];
                }
            }
        }
        res
    }
}