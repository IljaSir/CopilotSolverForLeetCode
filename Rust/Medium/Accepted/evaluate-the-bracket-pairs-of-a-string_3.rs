impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for k in knowledge {
            map.insert(k[0].clone(), k[1].clone());
        }
        let mut ans = String::new();
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with('(') {
                let mut j = i + 1;
                while j < s.len() && s[j..].starts_with(')') == false {
                    j += 1;
                }
                let key = s[i+1..j].to_string();
                ans.push_str(map.get(&key).unwrap_or(&"?".to_string()));
                i = j + 1;
            } else {
                ans.push(s[i..].chars().next().unwrap());
                i += 1;
            }
        }
        ans
    }
}