impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        if num == 0 { return "0".to_string(); }
        let mut num = num;
        let mut result = String::new();
        let mut count = 0;
        let mut hex = vec!['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];
        while count < 8 {
            let index = num & 15;
            num = num >> 4;
            result.push(hex[index as usize]);
            count += 1;
        }
        result.chars().rev().collect()
    }
}