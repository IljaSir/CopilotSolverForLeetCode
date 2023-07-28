impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let mut res = vec![0; num1.len() + num2.len()];
        for (i, c1) in num1.chars().rev().enumerate() {
            for (j, c2) in num2.chars().rev().enumerate() {
                let sum = (c1 as u8 - b'0') * (c2 as u8 - b'0') + res[i + j];
                res[i + j] = sum % 10;
                res[i + j + 1] += sum / 10;
            }
        }
        let mut s = res.iter().rev().skip_while(|&&x| x == 0).map(|&x| (x + b'0') as char).collect::<String>();
        if s.is_empty() {
            s = "0".to_string();
        }
        s
    }
}