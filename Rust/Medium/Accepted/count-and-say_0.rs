impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 1..n {
            s = Self::say(&s);
        }
        s
    }
    fn say(s: &str) -> String {
        let mut s = s.chars().peekable();
        let mut r = String::new();
        while let Some(c) = s.next() {
            let mut count = 1;
            while let Some(&next) = s.peek() {
                if next == c {
                    count += 1;
                    s.next();
                } else {
                    break;
                }
            }
            r.push_str(&count.to_string());
            r.push(c);
        }
        r
    }
}