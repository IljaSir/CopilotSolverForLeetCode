impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut stack: Vec<char> = Vec::new();
        let mut last_seen: [usize; 26] = [0; 26];
        let mut seen: [bool; 26] = [false; 26];
        let mut chars: Vec<char> = s.chars().collect();
        let mut i: usize = 0;
        while i < chars.len() {
            last_seen[(chars[i] as u8 - 'a' as u8) as usize] = i;
            i += 1;
        }
        i = 0;
        while i < chars.len() {
            let c: char = chars[i];
            if !seen[(c as u8 - 'a' as u8) as usize] {
                while let Some(&c2) = stack.last() {
                    if c2 < c && last_seen[(c2 as u8 - 'a' as u8) as usize] > i {
                        seen[(c2 as u8 - 'a' as u8) as usize] = false;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                seen[(c as u8 - 'a' as u8) as usize] = true;
                stack.push(c);
            }
            i += 1;
        }
        stack.iter().collect()
    }
}