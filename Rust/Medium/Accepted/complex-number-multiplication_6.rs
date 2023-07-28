impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let mut num1 = num1.split("+");
        let mut num2 = num2.split("+");
        let (a, b) = (num1.next().unwrap().parse::<i32>().unwrap(), num1.next().unwrap().trim_end_matches("i").parse::<i32>().unwrap());
        let (c, d) = (num2.next().unwrap().parse::<i32>().unwrap(), num2.next().unwrap().trim_end_matches("i").parse::<i32>().unwrap());
        let (e, f) = (a * c - b * d, a * d + b * c);
        format!("{}+{}i", e, f)
    }
}