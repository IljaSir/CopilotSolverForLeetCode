impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        

        let mut s = s.chars().collect::<Vec<char>>();
        let mut last = [0; 26];
        let mut seen = [false; 26];
        for (i, c) in s.iter().enumerate() {
            last[(c as u8 - 'a' as u8) as usize] = i;
        }
        let mut stack = Vec::new();
        for (i, c) in s.iter().enumerate() {
            let idx = (c as u8 - 'a' as u8) as usize;
            if seen[idx] {
                continue;
            }
            while let Some(&top) = stack.last() {
                if top > *c && i < last[(top as u8 - 'a' as u8) as usize] {
                    seen[(top as u8 - 'a' as u8) as usize] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(*c);
            seen[idx] = true;
        }
        stack.iter().collect::<String>()
    }
}