impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut chars = [0; 26];
        for ch in s.chars() {
            chars[ch as usize - 'a' as usize] += 1;
        }
        for ch in t.chars() {
            chars[ch as usize - 'a' as usize] -= 1;
        }
        chars.iter().map(|&x| x.abs()).sum::<i32>() / 2
    }
}