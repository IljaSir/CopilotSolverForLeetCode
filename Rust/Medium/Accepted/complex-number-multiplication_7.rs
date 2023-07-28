impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let (a,b) = Self::parse(num1);
        let (c,d) = Self::parse(num2);
        let real = a*c - b*d;
        let imag = a*d + b*c;
        format!("{}+{}i", real, imag)
    }
    fn parse(s: String) -> (i32, i32) {
        let (a,b) = s.split_at(s.find('+').unwrap());
        let a = a.parse::<i32>().unwrap();
        let b = b[1..b.len()-1].parse::<i32>().unwrap();
        (a,b)
    }
}