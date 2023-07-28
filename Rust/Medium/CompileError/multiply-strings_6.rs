impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let mut res: Vec<u32> = vec![0; num1.len() + num2.len()];
        let num1 = num1.as_bytes();
        let num2 = num2.as_bytes();
        for (i, &v1) in num1.iter().enumerate().rev() {
            for (j, &v2) in num2.iter().enumerate().rev() {
                let sum = (v1 - b'0') * (v2 - b'0') + res[i + j + 1];
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        let mut res = res.iter().skip_while(|&&v| v == 0).map(|&v| v + b'0').collect::<Vec<_>>();
        if res.is_empty() {
            res.push(b'0');
        }
        String::from_utf8(res).unwrap()
    }
}