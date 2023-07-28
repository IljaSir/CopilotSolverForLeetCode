impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = code.len();
        let mut res = vec![0; n];
        if k == 0 {
            return res;
        }
        let mut sum = 0;
        let (mut i, mut j) = if k > 0 {
            (1, k as usize + 1)
        } else {
            (n - 1, n + k as usize)
        };
        for _ in 0..k.abs() {
            sum += code[i % n];
            i += 1;
        }
        for _ in 0..n {
            res[j % n] = sum;
            sum -= code[i % n];
            sum += code[j % n];
            i += 1;
            j += 1;
        }
        res
    }
}