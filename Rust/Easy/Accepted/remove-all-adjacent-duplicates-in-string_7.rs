impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        
        let mut result: Vec<char> = Vec::new();
        for c in s.chars() {
            if let Some(&last) = result.last() {
                if last == c {
                    result.pop();
                    continue;
                }
            }
            result.push(c);
        }
        result.into_iter().collect()
    }
}