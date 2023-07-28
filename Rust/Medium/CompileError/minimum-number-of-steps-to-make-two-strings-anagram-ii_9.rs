impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut count = 0;
        let mut count_s = [0; 26];
        let mut count_t = [0; 26];
        for (s, t) in s.chars().zip(t.chars()) {
            count_s[(s as u8 - b'a') as usize] += 1;
            count_t[(t as u8 - b'a') as usize] += 1;
        }
        for i in 0..26 {
            count += (count_s[i] - count_t[i]).abs();
        }
        count / 2
    }
}