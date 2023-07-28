impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 1..n {
            let mut t = String::new();
            let mut i = 0;
            while i < s.len() {
                let mut j = i + 1;
                while j < s.len() && s.as_bytes()[j] == s.as_bytes()[i] {
                    j += 1;
                }
                t.push((j - i) as u8 + b'0');
                t.push(s.as_bytes()[i]);
                i = j;
            }
            s = t;
        }
        s
    }
}