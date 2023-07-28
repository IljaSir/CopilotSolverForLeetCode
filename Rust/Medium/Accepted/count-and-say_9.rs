impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut str = String::from("1");
        for _ in 1..n {
            let mut s = String::new();
            let mut count = 1;
            let mut chars = str.chars();
            let mut c = chars.next().unwrap();
            for ch in chars {
                if ch == c {
                    count += 1;
                } else {
                    s.push_str(&count.to_string());
                    s.push(c);
                    c = ch;
                    count = 1;
                }
            }
            s.push_str(&count.to_string());
            s.push(c);
            str = s;
        }
        str
    }
}