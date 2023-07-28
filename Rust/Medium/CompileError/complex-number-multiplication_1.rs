impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let (a, b) = Self::parse(&num1);
        let (c, d) = Self::parse(&num2);
        format!("{}+{}i", a * c - b * d, a * d + b * c)
    }
}