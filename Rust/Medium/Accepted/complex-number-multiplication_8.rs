impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let mut n1 = num1.split("+").map(|x| x.replace("i", "")).map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut n2 = num2.split("+").map(|x| x.replace("i", "")).map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let a = n1[0];
        let b = n1[1];
        let c = n2[0];
        let d = n2[1];
        let real = a*c - b*d;
        let imag = a*d + b*c;
        format!("{}+{}i", real, imag)
    }
}