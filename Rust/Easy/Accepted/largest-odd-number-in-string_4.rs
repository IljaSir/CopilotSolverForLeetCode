impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut i = num.len();
        while i > 0 {
            if num[i-1..i].parse::<i32>().unwrap() % 2 == 1 {
                return num[..i].to_string();
            }
            i -= 1;
        }
        return "".to_string();
    }
}