impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _i in 1..n {
            let mut t = String::new();
            let mut count = 1;
            let mut ch = s.chars().nth(0).unwrap();
            for j in 1..s.len() {
                let c = s.chars().nth(j).unwrap();
                if c == ch {
                    count += 1;
                } else {
                    t.push_str(&count.to_string());
                    t.push(ch);
                    ch = c;
                    count = 1;
                }
            }
            t.push_str(&count.to_string());
            t.push(ch);
            s = t;
        }
        s
    }
}