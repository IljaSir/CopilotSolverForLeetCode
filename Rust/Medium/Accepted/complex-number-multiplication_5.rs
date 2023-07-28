impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let mut num1 = num1.split('+');
        let mut num2 = num2.split('+');
        let real1 = num1.next().unwrap().parse::<i32>().unwrap();
        let imaginary1 = num1.next().unwrap().replace("i", "").parse::<i32>().unwrap();
        let real2 = num2.next().unwrap().parse::<i32>().unwrap();
        let imaginary2 = num2.next().unwrap().replace("i", "").parse::<i32>().unwrap();
        let real = real1 * real2 - imaginary1 * imaginary2;
        let imaginary = real1 * imaginary2 + real2 * imaginary1;
        format!("{}+{}i", real, imaginary)
    }
}