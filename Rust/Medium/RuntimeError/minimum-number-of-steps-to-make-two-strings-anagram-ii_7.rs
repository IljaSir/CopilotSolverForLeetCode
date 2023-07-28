impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut t = t.into_bytes();
        let mut cnt = [0; 26];
        for i in 0..s.len() {
            cnt[(s[i] - b'a') as usize] += 1;
            cnt[(t[i] - b'a') as usize] -= 1;
        }
        cnt.iter().map(|&x| if x > 0 { x } else { 0 }).sum()
    }
}