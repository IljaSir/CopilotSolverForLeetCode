impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut count = vec![0; 26 * 26];
        for word in words {
            let mut mask = 0;
            for c in word.chars() {
                mask |= 1 << (c as u8 - b'a');
            }
            if mask.count_ones() > 1 {
                continue;
            }
            let mask = mask as usize;
            count[mask] = count[mask].max(word.len());
        }
        for i in 0..26 {
            for j in 0..26 {
                let mask = 1 << i | 1 << j;
                res += count[mask] * count[mask ^ 0x3ff];
            }
        }
        for mask in 0..26 * 26 {
            res += count[mask] * count[mask] / 2;
        }
        res as i32
    }
}