impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut prev = -1;
        for word in s.split(' ') {
            if let Ok(num) = word.parse::<i32>() {
                if num <= prev {
                    return false;
                }
                prev = num;
            }
        }
        true
    }
}