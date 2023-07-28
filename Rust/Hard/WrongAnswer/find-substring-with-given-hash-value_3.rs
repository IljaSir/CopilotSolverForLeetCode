impl Solution {
    pub fn sub_str_hash(s: String, power: i32, modulo: i32, k: i32, hash_value: i32) -> String {
        
        let mut p = 1;
        let mut h = 0;
        let mut s = s.as_bytes().to_vec();
        let mut ans = String::new();
        for i in 0..k {
            h = (h + (s[i as usize] - 'a' as u8 + 1) as i32 * p) % modulo;
            p = p * power % modulo;
        }
        if h == hash_value {
            for i in 0..k {
                ans.push(s[i as usize] as char);
            }
            return ans;
        }
        for i in k..s.len() as i32 {
            h = (h - (s[(i - k) as usize] - 'a' as u8 + 1) as i32 + modulo) % modulo;
            h = (h * power + (s[i as usize] - 'a' as u8 + 1) as i32) % modulo;
            if h == hash_value {
                for j in (i - k + 1)..(i + 1) {
                    ans.push(s[j as usize] as char);
                }
                return ans;
            }
        }
        ans
    }
}