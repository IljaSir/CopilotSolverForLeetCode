impl Solution {
    pub fn sub_str_hash(s: String, power: i32, modulo: i32, k: i32, hash_value: i32) -> String {
        
        let mut power = power;
        let mut hash = 0;
        let mut p = 1;
        let mut s = s.as_bytes().to_vec();
        for i in 0..k {
            hash = (hash + (s[i as usize] - b'a' + 1) as i32 * p) % modulo;
            p = (p * power) % modulo;
        }
        if hash == hash_value {
            return String::from_utf8(s[0..k as usize].to_vec()).unwrap();
        }
        for i in k..s.len() as i32 {
            hash = (hash - (s[(i - k) as usize] - b'a' + 1) as i32 * power) % modulo;
            hash = (hash * power) % modulo;
            hash = (hash + (s[i as usize] - b'a' + 1) as i32) % modulo;
            if hash == hash_value {
                return String::from_utf8(s[(i - k + 1) as usize..(i + 1) as usize].to_vec()).unwrap();
            }
        }
        "".to_string()
    }
}