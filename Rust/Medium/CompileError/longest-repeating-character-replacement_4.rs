impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut count = vec![0; 26];
        let mut max_count = 0;
        let mut start = 0;
        let mut max_len = 0;
        let s: Vec<char> = s.chars().collect();
        for (end, c) in s.iter().enumerate() {
            let c = c as u8 - 'A' as u8;
            count[c as usize] += 1;
            max_count = max_count.max(count[c as usize]);
            while end - start + 1 - max_count > k {
                count[s[start] as u8 - 'A' as u8] -= 1;
                start += 1;
            }
            max_len = max_len.max(end - start + 1);
        }
        max_len as i32
    }
}