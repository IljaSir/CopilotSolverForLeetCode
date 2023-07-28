impl Solution {
    pub fn longest_substring(s: String, k: i32) -> i32 {
        

        let mut max_len = 0;
        for c in 'a' as u8 .. 'z' as u8 + 1 {
            let mut i = 0;
            let mut j = 0;
            let mut count = 0;
            let mut less = 0;
            let mut freq = [0; 26];
            while j < s.len() {
                let idx = s.as_bytes()[j] - 'a' as u8;
                freq[idx as usize] += 1;
                if freq[idx as usize] == k {
                    count += 1;
                } else if freq[idx as usize] == 1 {
                    less += 1;
                }
                while less > 0 {
                    let idx = s.as_bytes()[i] - 'a' as u8;
                    freq[idx as usize] -= 1;
                    if freq[idx as usize] == k - 1 {
                        count -= 1;
                    } else if freq[idx as usize] == 0 {
                        less -= 1;
                    }
                    i += 1;
                }
                if count == c - 'a' as u8 + 1 {
                    max_len = max_len.max(j - i + 1);
                }
                j += 1;
            }
        }
        max_len as i32
    }
}