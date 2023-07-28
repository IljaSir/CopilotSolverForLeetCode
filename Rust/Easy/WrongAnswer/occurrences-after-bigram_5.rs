impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res = vec![];
        let mut words = text.split_whitespace();
        let mut first = first;
        let mut second = second;
        let mut third = words.next();
        while third.is_some() {
            if first == second && second == third.unwrap() {
                third = words.next();
                continue;
            }
            if first == second && second != third.unwrap() {
                first = second;
                second = third.unwrap().to_string();
                third = words.next();
                continue;
            }
            if first != second && second == third.unwrap() {
                first = second;
                second = third.unwrap().to_string();
                third = words.next();
                continue;
            }
            if first != second && second != third.unwrap() {
                first = second;
                second = third.unwrap().to_string();
                third = words.next();
                continue;
            }
        }
        return res;
    }
}