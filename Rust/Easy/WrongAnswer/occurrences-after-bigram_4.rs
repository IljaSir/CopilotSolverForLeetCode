impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res = vec![];
        let mut words = text.split_whitespace();
        let mut first = first;
        let mut second = second;
        while let Some(third) = words.next() {
            if first == second && second == third {
                continue;
            }
            if first == second {
                res.push(third.to_string());
            }
            first = second;
            second = third.to_string();
        }
        res
    }
}