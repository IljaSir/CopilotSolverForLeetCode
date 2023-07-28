impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut last = 0;
        let mut flag = true;
        for i in s.split_whitespace() {
            if let Ok(n) = i.parse::<i32>() {
                if n <= last {
                    flag = false;
                    break;
                }
                last = n;
            }
        }
        flag
    }
}