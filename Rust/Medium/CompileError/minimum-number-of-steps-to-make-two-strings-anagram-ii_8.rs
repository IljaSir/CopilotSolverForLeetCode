impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut t = t.into_bytes();
        let mut cnt = vec![0; 26];
        for i in 0..s.len() {
            cnt[(s[i] - 'a' as u8) as usize] += 1;
            cnt[(t[i] - 'a' as u8) as usize] -= 1;
        }
        cnt.iter().map(|x| x.abs()).sum::<i32>() / 2
    }
}