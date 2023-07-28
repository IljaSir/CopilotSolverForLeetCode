impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut words: Vec<&str> = text.split(" ").collect();
        if words.len() < 3 {
            return res;
        }
        for i in 0..words.len()-2 {
            if words[i] == first && words[i+1] == second {
                res.push(words[i+2].to_string());
            }
        }
        res
    }
}