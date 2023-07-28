impl Solution {
    pub fn sub_str_hash(s: String, power: i32, modulo: i32, k: i32, hash_value: i32) -> String {
        
        let mut p = 1;
        for i in 0..k as usize {
            p = (p * power) % modulo;
        }
        let mut h = 0;
        for i in 0..k as usize {
            h = (h * power + (s.chars().nth(i).unwrap() as i32 - 'a' as i32 + 1)) % modulo;
        }
        if h == hash_value {
            return s[0..k as usize].to_string();
        }
        let mut i = 0;
        let mut j = k as usize;
        while j < s.len() {
            h = (h - (s.chars().nth(i).unwrap() as i32 - 'a' as i32 + 1) * p) % modulo;
            h = (h + modulo) % modulo;
            h = (h * power + (s.chars().nth(j).unwrap() as i32 - 'a' as i32 + 1)) % modulo;
            if h == hash_value {
                return s[i+1..j+1].to_string();
            }
            i += 1;
            j += 1;
        }
        return "".to_string();
    }
}