impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![0; code.len()];
        if k == 0 {
            return res;
        }
        let mut sum = 0;
        let n = code.len();
        let k = k as usize;
        for i in 0..k {
            sum += code[i];
        }
        for i in 0..n {
            res[i] = sum;
            sum -= code[i];
            sum += code[(i + k) % n];
        }
        res
    }
}