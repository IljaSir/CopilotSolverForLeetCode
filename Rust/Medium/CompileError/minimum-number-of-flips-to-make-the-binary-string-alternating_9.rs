impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut cnt = 0;
        for i in 0..n {
            if s[i] != s[i % 2] {
                cnt += 1;
            }
        }
        let mut res = cnt;
        for i in 0..n {
            if s[i] != s[i % 2] {
                32
    }
}