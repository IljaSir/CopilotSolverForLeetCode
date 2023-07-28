impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut chars: Vec<u8> = s.into_bytes();
        let mut counts: Vec<usize> = vec![0; 26];
        let mut max_count = 0;
        let mut max_char = 0;
        for c in chars.iter() {
            let idx = (c - b'a') as usize;
            counts[idx] += 1;
            if counts[idx] > max_count {
                max_count = counts[idx];
                max_char = idx;
            }
        }
        if max_count > (chars.len() + 1) / 2 {
            return "".to_string();
        }
        let mut i = 0;
        while i < chars.len() {
            chars[i] = (b'a' + max_char as u8) as u8;
            counts[max_char] -= 1;
            i += 2;
        }
        let mut j = 1;
        for k in 0..26 {
            while counts[k] > 0 {
                if j >= chars.len() {
                    j = 1;
                }
                chars[j] = (b'a' + k as u8) as u8;
                counts[k] -= 1;
                j += 2;
            }
        }
        String::from_utf8(chars).unwrap()
    }
}