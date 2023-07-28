impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 1..n {
            let mut count = 1;
            let mut i = 0;
            let mut tmp = String::new();
            while i < s.len() {
                if i + 1 < s.len() && s.chars().nth(i).unwrap() == s.chars().nth(i + 1).unwrap() {
                    count += 1;
                } else {
                    tmp.push_str(&count.to_string());
                    tmp.push(s.chars().nth(i).unwrap());
                    count = 1;
                }
                i += 1;
            }
            s = tmp;
        }
        s
    }
}