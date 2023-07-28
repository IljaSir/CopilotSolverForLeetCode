impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        
        format!("{:b}", i64::from_str_radix(&a, 2).unwrap() + i64::from_str_radix(&b, 2).unwrap())
    }
}