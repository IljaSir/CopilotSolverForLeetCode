impl Solution {
    pub fn smallest_subsequence(s: String, k: i32, letter: char, repetition: i32) -> String {
        
        let mut stack: Vec<char> = vec![];
        let mut cnt = vec![0;26];
        let mut used = vec![false;26];
        let mut k = k as usize;
        let repetition = repetition as usize;
        let mut letter = letter as usize - 'a' as usize;
        for c in s.chars() {
            let c = c as usize - 'a' as usize;
            cnt[c] += 1;
        }
        for c in s.chars() {
            let c = c as usize - 'a' as usize;
            cnt[c] -= 1;
            if used[c] { continue; }
            while let Some(&v) = stack.last() {
                if v > c && cnt[v] > 0 {
                    used[stack.pop().unwrap()] = false;
                } else {
                    break;
                }
            }
            if c == letter {
                if repetition > stack.len() {
                    stack.push(c as u8 as char);
                    used[c] = true;
                }
            } else {
                stack.push(c as u8 as char);
                used[c] = true;
            }
        }
        stack.into_iter().take(k).collect()
    }
}