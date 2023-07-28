impl Solution {
    pub fn count_and_say(n: i32) -> String {
        

        let mut s = String::from("1");
        for _ in 1..n {
            s = Solution::count_and_say_once(&s);
        }
        s
    }
    
    fn count_and_say_once(s: &str) -> String {
        let mut cs = String::new();
        let mut i = 0;
        while i < s.len() {
            let mut c = 0;
            let mut j = i;
            while j < s.len() && s.as_bytes()[j] == s.as_bytes()[i] {
                c += 1;
                j += 1;
            }
            cs.push_str(&c.to_string());
            cs.push(s.as_bytes()[i] as char);
            i = j;
        }
        cs
    }
}