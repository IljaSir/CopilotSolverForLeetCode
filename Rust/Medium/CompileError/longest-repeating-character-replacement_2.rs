impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut max_count = 0;
        let mut max_len = 0;
        let mut left = 0;
        let mut right = 0;
        let mut count = vec![0; 26];
        for c in s.chars() {
            let idx = (c as u8 - b'A') as usize;
            count[idx] += 1;
            max_count = max_count.max(count[idx]);
            right += 1;
            if right - left > max_count + k {
                count[(s.chars().nth(left).unwrap() as u8 - b'A') as usize] -= 1;
                left += 1;
            }
            max_len = max_len.max(right - left);
        }
        max_len as i32
    }
}