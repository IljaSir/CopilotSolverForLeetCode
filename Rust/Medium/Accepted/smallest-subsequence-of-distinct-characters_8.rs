impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut last = [0; 26];
        let mut seen = [false; 26];
        let mut chars = s.chars().collect::<Vec<char>>();
        for i in 0..chars.len() {
            last[(chars[i] as u8 - 'a' as u8) as usize] = i;
        }
        for i in 0..chars.len() {
            let c = chars[i];
            if seen[(c as u8 - 'a' as u8) as usize] {
                continue;
            }
            while let Some(&c1) = stack.last() {
                if c1 as u8 - 'a' as u8 > c as u8 - 'a' as u8 && last[(c1 as u8 - 'a' as u8) as usize] > i {
                    stack.pop();
                    seen[(c1 as u8 - 'a' as u8) as usize] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            seen[(c as u8 - 'a' as u8) as usize] = true;
        }
        stack.iter().collect()
    }
}