impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut l = s.len();
        let mut r = 0;
        let mut res = 0;
        let mut c = s.as_bytes();
        for i in 0..s.len() {
            if c[i] == c[l-1] {
                r += 1;
            } else {
                res += r * (r + 1) / 2;
                r = 0;
            }
            l -= 1;
        }
        res += r * (r + 1) / 2;
        res as i64
    }
}