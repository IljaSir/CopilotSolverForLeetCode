impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = "1".to_string();
        for _ in 1..n {
            let mut t = String::new();
            let mut i = 0;
            while i < s.len() {
                let mut j = i;
                while j < s.len() && s.as_bytes()[j] == s.as_bytes()[i] {
                    j += 1;
                }
                t.push((j - i) as u8 + '0' as u8);
                t.push(s.as_bytes()[i]);
                i = j;
            }
            s = t;
        }
        s
    }
}