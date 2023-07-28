impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut t = 0;
        let mut f = 0;
        let mut l = 0;
        let mut r = 0;
        let mut res = 0;
        let k = k as usize;
        let answer_key = answer_key.into_bytes();
        let n = answer_key.len();
        while r < n {
            if answer_key[r] == b'T' {
                t += 1;
            } else {
                f += 1;
            }
            while t > k && f > k {
                if answer_key[l] == b'T' {
                    t -= 1;
                } else {
                    f -= 1;
                }
                l += 1;
            }
            res = res.max(r - l + 1);
            r += 1;
        }
        res as i32
    }
}