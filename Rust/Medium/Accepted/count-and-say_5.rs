impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 1..n {
            let mut i = 0;
            let mut j = 0;
            let mut t = String::new();
            while i < s.len() {
                while j < s.len() && s.as_bytes()[j] == s.as_bytes()[i] {
                    j += 1;
                }
                t += &((j - i).to_string());
                t.push(s.as_bytes()[i] as char);
                i = j;
            }
            s = t;
        }
        s
    }
}