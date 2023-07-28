impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let n1 = num1.chars().collect::<Vec<char>>();
        let n2 = num2.chars().collect::<Vec<char>>();
        let mut res = vec![0; n1.len() + n2.len()];
        for i in (0..n1.len()).rev() {
            for j in (0..n2.len()).rev() {
                let sum = (n1[i] as u8 - '0' as u8) * (n2[j] as u8 - '0' as u8) + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        let mut s = String::new();
        for i in 0..res.len() {
            if i == 0 && res[i] == 0 {
                continue;
            }
            s.push((res[i] + '0' as u8) as char);
        }
        if s.len() == 0 {
            s.push('0');
        }
        return s;
    }
}