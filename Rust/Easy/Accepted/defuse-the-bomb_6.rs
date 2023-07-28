impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = code.len() as i32;
        let mut res = vec![0; n as usize];
        if k == 0 {
            return res;
        }
        let mut sum = 0;
        let mut start = 1;
        let mut end = k;
        if k < 0 {
            start = n + k;
            end = n - 1;
        }
        for i in start..=end {
            sum += code[i as usize];
        }
        for i in 0..n {
            res[i as usize] = sum;
            sum -= code[start as usize];
            start = (start + 1) % n;
            end = (end + 1) % n;
            sum += code[end as usize];
        }
        res
    }
}