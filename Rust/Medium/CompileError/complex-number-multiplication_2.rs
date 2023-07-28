impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let (a, b) = Self::parse_complex(&num1);
        let (c, d) = Self::parse_complex(&num2);
        let real = a * c - b * d;
        let imaginary = a * d + b * c;
        format!("{}+{}i", real, imaginary)
    }
}