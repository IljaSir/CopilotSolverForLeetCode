impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut upper = vec![false; 26];
        let mut lower = vec![false; 26];
        let mut ans = "".to_string();
        for c in s.chars() {
            if c.is_uppercase() {
                upper[c as usize - 'A' as usize] = true;
            } else {
                lower[c as usize - 'a' as usize] = true;
            }
        }
        for i in (0..26).rev() {
            if upper[i] && lower[i] {
                ans.push((i + 'A' as usize) as u8 as char);
                break;
            }
        }
        ans
    }
}