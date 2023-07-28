impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let mut num1 = num1.split("+").collect::<Vec<&str>>();
        let mut num2 = num2.split("+").collect::<Vec<&str>>();
        let mut num1_real = num1[0].parse::<i32>().unwrap();
        let mut num1_imaginary = num1[1].replace("i", "").parse::<i32>().unwrap();
        let mut num2_real = num2[0].parse::<i32>().unwrap();
        let mut num2_imaginary = num2[1].replace("i", "").parse::<i32>().unwrap();
        let mut res_real = num1_real * num2_real - num1_imaginary * num2_imaginary;
        let mut res_imaginary = num1_real * num2_imaginary + num1_imaginary * num2_real;
        format!("{}+{}i", res_real, res_imaginary)
    }
}