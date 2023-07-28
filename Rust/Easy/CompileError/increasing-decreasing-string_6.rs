impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s;
        let mut s = s.as_bytes_mut();
        s.sort();
        let mut s = String::from_utf8(s.to_vec()).unwrap();
        let mut result = String::new();
        let mut i = 0;
        while s.len() > 0 {
            let mut j = 0;
            let mut k = 0;
            let mut prev = s.chars().nth(0).unwrap();
            while j < s.len() {
                let c = s.chars().nth(j).unwrap();
                if prev != c {
                    result.push(prev);
                    prev = c;
                    k = j;
                }
                j += 1;
            }
            if prev != s.chars().nth(s.len() - 1).unwrap() {
                result.push(prev);
            }
            s.drain(k..);
            s = s.chars().rev().collect::<String>();
        }
        result
    }
}