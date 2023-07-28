impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res = Vec::new();
        let words = text.split(" ").collect::<Vec<&str>>();
        let n = words.len();
        for i in 0..n-2 {
            if words[i] == first && words[i+1] == second {
                res.push(words[i+2].to_string());
            }
        }
        res
    }
}