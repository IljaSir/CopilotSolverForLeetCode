impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut count = [0; 26];
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        let k = k as usize;
        let s: Vec<char> = s.chars().collect();
        while right < s.len() {
            count[(s[right] as u8 - b'A') as usize] += 1;
            max = max.max(count[(s[right] as u8 - b'A') as usize]);
            if right - left + 1 - max > k {
                count[(s[left] as u8 - b'A') as usize] -= 1;
                left += 1;
            }
            right += 1;
        }
        (right - left) as i32
    }
}