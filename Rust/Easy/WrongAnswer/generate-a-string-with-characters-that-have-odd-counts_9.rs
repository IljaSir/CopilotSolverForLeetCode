impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        String::from_utf8(vec![b'a'; n as usize]).unwrap()
    }
}