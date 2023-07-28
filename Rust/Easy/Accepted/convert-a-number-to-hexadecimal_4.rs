impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        let mut num = num as u32;
        if num == 0 {
            return "0".to_string();
        }
        let mut result = String::new();
        let mut digits = vec!['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];
        while num > 0 {
            result.push(digits[(num % 16) as usize]);
            num /= 16;
        }
        result.chars().rev().collect()
    }
}