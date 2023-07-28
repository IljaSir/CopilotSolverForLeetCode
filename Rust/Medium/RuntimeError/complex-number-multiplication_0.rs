impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let (a, b) = num1.split_at(num1.find('+').unwrap());
        let (c, d) = num2.split_at(num2.find('+').unwrap());
        let a = a.parse::<i32>().unwrap();
        let b = b.trim_end_matches('i').parse::<i32>().unwrap();
        let c = c.parse::<i32>().unwrap();
        let d = d.trim_end_matches('i').parse::<i32>().unwrap();
        format!("{}+{}i", a * c - b * d, a * d + b * c)
    }
}