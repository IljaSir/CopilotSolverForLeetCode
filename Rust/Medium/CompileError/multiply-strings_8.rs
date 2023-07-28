impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let mut result = vec![0;num1.len() + num2.len()];
        let num1 = num1.as_bytes();
        let num2 = num2.as_bytes();
        for (i, &ni) in num1.iter().rev().enumerate() {
            for (j, &nj) in num2.iter().rev().enumerate() {
                let sum = (ni - b'0') * (nj - b'0') + result[i + j];
                result[i + j] = sum % 10;
                result[i + j + 1] += sum / 10;
            }
        }
        let mut result = result.into_iter().rev().skip_while(|&x| x == 0);
        if let Some(x) = result.next() {
            let mut result = String::new();
            result.push((x + b'0') as char);
            for &x in result {
                result.push((x + b'0') as char);
            }
            result
        } else {
            "0".to_string()
        }
    }
}