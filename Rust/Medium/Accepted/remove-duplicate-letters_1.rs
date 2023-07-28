impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        

        let mut last = [0; 26];
        let mut seen = [false; 26];
        let mut stack = Vec::new();
        let mut res = String::new();
        for (i, c) in s.chars().enumerate() {
            last[(c as u8 - b'a') as usize] = i;
        }
        for (i, c) in s.chars().enumerate() {
            let index = (c as u8 - b'a') as usize;
            if seen[index] {
                continue;
            }
            while let Some(&v) = stack.last() {
                if v > c && last[(v as u8 - b'a') as usize] > i {
                    seen[(v as u8 - b'a') as usize] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(c);
            seen[index] = true;
        }
        for c in stack {
            res.push(c);
        }
        res
    }
}