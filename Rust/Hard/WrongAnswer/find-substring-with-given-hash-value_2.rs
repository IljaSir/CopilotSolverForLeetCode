impl Solution {
    pub fn sub_str_hash(s: String, power: i32, modulo: i32, k: i32, hash_value: i32) -> String {
        
        let mut p = 1;
        let mut hash = 0;
        let mut result = String::new();
        for (i, c) in s.chars().enumerate() {
            if i < k as usize {
                hash = (hash + (c as i32 - 96) * p) % modulo;
                p = (p * power) % modulo;
            } else {
                hash = (hash + modulo - (s.chars().nth(i - k as usize).unwrap() as i32 - 96) * p % modulo) % modulo;
                hash = (hash * power + (c as i32 - 96)) % modulo;
            }
            if i >= k as usize - 1 && hash == hash_value {
                result = s[i - k as usize + 1..=i].to_string();
                break;
            }
        }
        result
    }
}