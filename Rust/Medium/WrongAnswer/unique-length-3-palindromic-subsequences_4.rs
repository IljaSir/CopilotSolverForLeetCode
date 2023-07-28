impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut count = 0;
        let mut left = vec![0; 26];
        let mut right = vec![0; 26];
        let mut seen = vec![0; 26];
        let mut chars = s.chars();
        let mut i = 0;
        while let Some(c) = chars.next() {
            let idx = (c as u8 - b'a') as usize;
            if left[idx] == 0 {
                left[idx] = i + 1;
            }
            right[idx] = i + 1;
            i += 1;
        }
        for i in 0..26 {
            if left[i] != 0 {
                let mut j = left[i];
                while j < right[i] {
                    let c = s.chars().nth(j - 1).unwrap();
                    let idx = (c as u8 - b'a') as usize;
                    if seen[idx] == 0 {
                        count += 1;
                        seen[idx] = 1;
                    }
                    j += 1;
                }
                seen = vec![0; 26];
            }
        }
        count
    }
}