impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![0; code.len()];
        if k == 0 {
            return res;
        }
        let mut sum = 0;
        let (mut i, mut j) = (0, 0);
        if k > 0 {
            while j < k as usize {
                sum += code[j];
                j += 1;
            }
            while i < code.len() {
                res[i] = sum;
                sum -= code[i];
                sum += code[j];
                i += 1;
                j += 1;
                if j == code.len() {
                    j = 0;
                }
            }
        } else {
            while j < -k as usize {
                sum += code[j];
                j += 1;
            }
            while i < code.len() {
                res[i] = sum;
                sum -= code[(i + k as usize) % code.len()];
                sum += code[(j + k as usize) % code.len()];
                i += 1;
                j += 1;
                if j == code.len() {
                    j = 0;
                }
            }
        }
        res
    }
}