impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with('(') {
                let mut j = i + 1;
                while j < s.len() && s[j..].starts_with(')') == false {
                    j += 1;
                }
                let key = &s[i + 1..j];
                let value = knowledge.iter().find(|x| x[0] == key).map_or("?", |x| &x[1]);
                res.push_str(value);
                i = j + 1;
            } else {
                res.push(s[i..].chars().next().unwrap());
                i += 1;
            }
        }
        res
    }
}