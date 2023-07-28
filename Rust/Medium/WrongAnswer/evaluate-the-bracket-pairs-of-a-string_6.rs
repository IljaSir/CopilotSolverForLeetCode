impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut s = s;
        for pair in knowledge {
            let key = format!("({})", pair[0]);
            s = s.replace(&key, &pair[1]);
        }
        s.replace("(", "?").replace(")", "?")
    }
}