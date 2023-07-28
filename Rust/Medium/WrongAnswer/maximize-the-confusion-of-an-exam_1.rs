impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut l = 0;
        let mut r = 0;
        let mut t = 0;
        let mut f = 0;
        let mut k = k;
        let mut n = answer_key.len();
        let mut v: Vec<char> = answer_key.chars().collect();
        while r < n {
            if v[r] == 'T' {
                t += 1;
            } else {
                f += 1;
            }
            while t > k && f > k {
                if v[l] == 'T' {
                    t -= 1;
                } else {
                    f -= 1;
                }
                l += 1;
            }
            ans = ans.max(t).max(f);
            r += 1;
        }
        ans as i32
    }
}