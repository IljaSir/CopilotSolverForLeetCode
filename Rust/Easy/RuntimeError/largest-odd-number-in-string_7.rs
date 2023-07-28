impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut i = num.len();
        while i > 0 {
            let s = num.get(0..i).unwrap();
            if s.parse::<i32>().unwrap() % 2 == 1 {
                return s.to_string();
            }
            i -= 1;
        }
        "".to_string()
    }
}