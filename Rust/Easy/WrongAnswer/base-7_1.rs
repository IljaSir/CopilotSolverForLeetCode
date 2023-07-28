impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        num.to_string()
            .parse::<i32>()
            .unwrap()
            .abs()
            .to_string()
            .chars()
            .rev()
            .collect::<String>()
            .parse::<i32>()
            .unwrap()
            .to_string()
    }
}