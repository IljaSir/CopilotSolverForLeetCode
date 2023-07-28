impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let mut num1: Vec<u8> = num1.into_bytes();
        let mut num2: Vec<u8> = num2.into_bytes();
        let mut res: Vec<u8> = vec![0; num1.len() + num2.len()];
        for i in (0..num1.len()).rev() {
            for j in (0..num2.len()).rev() {
                let sum = (num1[i] - b'0') * (num2[j] - b'0') + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        let mut i = 0;
        while i < res.len() - 1 && res[i] == 0 {
            i += 1;
        }
        res[i..].iter().map(|x| (x + b'0') as char).collect()
    }
}