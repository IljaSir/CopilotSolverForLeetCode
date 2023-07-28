impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        while i < n {
            if i == n - 1 && n % 2 == 0 {
                res.push('z');
            } else {
                res.push('a');
            }
            i += 1;
        }
        res
    }
}