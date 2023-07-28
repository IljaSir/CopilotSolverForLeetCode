impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut stack: Vec<char> = Vec::new();
        let mut s = s.chars().collect::<Vec<char>>();
        let mut last_occurrence = vec![0; 26];
        let mut visited = vec![false; 26];
        for i in 0..s.len() {
            last_occurrence[(s[i] as u8 - 'a' as u8) as usize] = i;
        }
        for i in 0..s.len() {
            if visited[(s[i] as u8 - 'a' as u8) as usize] {
                continue;
            }
            while let Some(&c) = stack.last() {
                if c < s[i] && last_occurrence[(c as u8 - 'a' as u8) as usize] > i {
                    visited[(c as u8 - 'a' as u8) as usize] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(s[i]);
            visited[(s[i] as u8 - 'a' as u8) as usize] = true;
        }
        stack.into_iter().collect()
    }
}