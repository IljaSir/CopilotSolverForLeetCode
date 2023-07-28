impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut result = vec![0; code.len()];
        if k == 0 {
            return result;
        }
        let mut sum = code.iter().take(k.abs() as usize).sum::<i32>();
        for i in 0..code.len() {
            result[i] = sum;
            if k > 0 {
                sum -= code[(i + code.len() - k as usize) % code.len()];
                sum += code[(i + 1) % code.len()];
            } else {
                sum += code[(i + code.len() + k as usize) % code.len()];
                sum -= code[i];
            }
        }
        result
    }
}