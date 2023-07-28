impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let k = k as usize;
        let n = answer_key.len();
        let (mut t, mut f) = (0, 0);
        let mut (mut l, mut r) = (0, 0);
        let mut res = 0;
        while r < n {
            if answer_key.as_bytes()[r] == b'T' {
                t += 1;
            } else {
                f += 1;
            }
            while t > k && f > k {
                if answer_key.as_bytes()[l] == b'T' {
                    t -= 1;
                } else {
                    f -= 1;
                }
                l += 1;
            }
            res = res.max(t).max(f);
            r += 1;
        }
        res as i32
    }
}