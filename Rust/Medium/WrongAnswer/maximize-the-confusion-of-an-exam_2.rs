impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let k = k as usize;
        let mut answer_key = answer_key.as_bytes().to_vec();
        let mut f = vec![0; answer_key.len()];
        let mut t = vec![0; answer_key.len()];
        let mut max = 0;
        for i in 0..answer_key.len() {
            if answer_key[i] == b'F' {
                f[i] = 1;
            } else {
                t[i] = 1;
            }
            if i > 0 {
                f[i] += f[i - 1];
                t[i] += t[i - 1];
            }
            if i >= k {
                max = max.max(f[i] - f[i - k]);
                max = max.max(t[i] - t[i - k]);
            }
        }
        max.max(f[k - 1]).max(t[k - 1]) as i32
    }
}