impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![0; code.len()];
        if k == 0 {
            return res;
        }
        if k > 0 {
            for i in 0..code.len() {
                for j in 0..k as usize {
                    res[i] += code[(i + 1 + j) % code.len()];
                }
            }
        } else {
            for i in 0..code.len() {
                for j in 0..-k as usize {
                    res[i] += code[(i + code.len() - j) % code.len()];
                }
            }
        }
        res
    }
}