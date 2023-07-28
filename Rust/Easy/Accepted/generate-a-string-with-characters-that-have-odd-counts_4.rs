impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        let mut result = String::new();
        if n % 2 == 0 {
            result.push('a');
            for _ in 1..n {
                result.push('b');
            }
        } else {
            for _ in 0..n {
                result.push('a');
            }
        }
        result
    }
}