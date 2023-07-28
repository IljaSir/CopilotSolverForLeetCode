impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut count = [0; 26];
        let s: Vec<char> = s.chars().collect();
        let mut max = 1;
        let mut left = 0;
        let mut right = 0;
        while right < s.len() {
            count[(s[right] as u8 - b'A') as usize] += 1;
            right += 1;
            while right - left - count.iter().max().unwrap() > k {
                count[(s[left] as u8 - b'A') as usize] -= 1;
                left += 1;
            }
            max = max.max(right - left);
        }
        max as i32
    }
}