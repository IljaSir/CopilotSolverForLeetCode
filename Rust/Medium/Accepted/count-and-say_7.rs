impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 2..=n {
            let mut tmp = String::new();
            let mut count = 1;
            let mut last = s.chars().nth(0).unwrap();
            for c in s.chars().skip(1) {
                if c == last {
                    count += 1;
                } else {
                    tmp.push_str(&count.to_string());
                    tmp.push(last);
                    last = c;
                    count = 1;
                }
            }
            tmp.push_str(&count.to_string());
            tmp.push(last);
            s = tmp;
        }
        s
    }
}