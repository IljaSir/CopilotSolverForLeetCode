impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 1..n {
            let mut i = 0;
            let mut j = 0;
            let mut t = String::new();
            while j < s.len() {
                if s.chars().nth(i).unwrap() != s.chars().nth(j).unwrap() {
                    t.push_str(&(j - i).to_string());
                    t.push(s.chars().nth(i).unwrap());
                    i = j;
                }
                j += 1;
            }
            t.push_str(&(j - i).to_string());
            t.push(s.chars().nth(i).unwrap());
            s = t;
        }
        s
    }
}