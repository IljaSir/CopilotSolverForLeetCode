impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut chars = vec![0; 26];
        for c in text.chars() {
            chars[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut ans = 0;
        loop {
            if chars[1] >= 1 && chars[0] >= 1 && chars[11] >= 2 && chars[14] >= 2 && chars[13] >= 1 {
                ans += 1;
                chars[1] -= 1;
                chars[0] -= 1;
                chars[11] -= 2;
                chars[14] -= 2;
                chars[13] -= 1;
            } else {
                break;
            }
        }
        ans
    }
}