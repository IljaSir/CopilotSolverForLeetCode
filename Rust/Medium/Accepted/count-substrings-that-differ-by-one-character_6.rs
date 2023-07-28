impl Solution {
    pub fn count_substrings(s: String, t: String) -> i32 {
        
        let m = s.len();
        let n = t.len();
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                let mut diff = 0;
                for k in 0..(m-i).min(n-j) {
                    if s.as_bytes()[i+k] != t.as_bytes()[j+k] {
                        diff += 1;
                    }
                    if diff == 2 {
                        break;
                    }
                    if diff == 1 {
                        ans += 1;
                    }
                }
            }
        }
        ans
    }
}