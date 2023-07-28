impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let mut res = vec![0; num1.len() + num2.len()];
        let bytes1 = num1.as_bytes();
        let bytes2 = num2.as_bytes();
        for i in (0..bytes1.len()).rev() {
            for j in (0..bytes2.len()).rev() {
                let mul = (bytes1[i] - b'0') * (bytes2[j] - b'0');
                let sum = mul + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        let mut res = res.into_iter().skip_while(|&x| x == 0).collect::<Vec<_>>();
        if res.is_empty() {
            return "0".to_string();
        }
        res.into_iter().map(|x| (x + b'0') as char).collect()
    }
}