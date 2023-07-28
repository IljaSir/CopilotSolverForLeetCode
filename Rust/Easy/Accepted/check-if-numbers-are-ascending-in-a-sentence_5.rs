impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut v: Vec<&str> = s.split(' ').collect();
        let mut prev = 0;
        for i in 0..v.len() {
            if let Ok(n) = v[i].parse::<i32>() {
                if n <= prev {
                    return false;
                }
                prev = n;
            }
        }
        true
    }
}