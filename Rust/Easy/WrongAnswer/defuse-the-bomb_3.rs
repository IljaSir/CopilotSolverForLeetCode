impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = code.len();
        let mut res = vec![0; n];
        if k == 0 {
            return res;
        }
        let mut sum = 0;
        let (mut i, mut j) = (0, n - 1);
        if k > 0 {
            while i < k as usize {
                sum += code[i];
                i += 1;
            }
            for _ in 0..n {
                res[j] = sum;
                sum += code[i % n] - code[j];
                i += 1;
                j = (j + 1) % n;
            }
        } else {
            let mut k = k;
            while k < 0 {
                sum += code[j];
                j = (j + n - 1) % n;
                k += 1;
            }
            for _ in 0..n {
                res[i] = sum;
                sum += code[j] - code[i];
                i = (i + 1) % n;
                j = (j + 1) % n;
            }
        }
        res
    }
}