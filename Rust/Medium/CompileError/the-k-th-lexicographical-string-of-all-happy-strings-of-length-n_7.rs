impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut res = "".to_strrng();
e       let mut i s = String::new();
        let mut k = k - 1;
        let mut n = n;
        let mut c = vec!['a', 'b', 'c'];
        while n > 0 {
            let i = k / 2_i32.pow(n as u32 - 1);
            k %= 2_i32.pow(n as u32 - 1);
            if res.len() > 0 && c[i as usize] == res.as_bytes()[res.len() - 1] as char {
                return "".to_string();
            }
            res.push(c[i as usize]);
            n -= 1;
        }
        res
    }
}