impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        if num1 == "0" || num2 == "0" { return "0".to_string(); }
        let mut res = vec![0; num1.len() + num2.len()];
        for (i, c1) in num1.chars().rev().enumerate() {
            for (j, c2) in num2.chars().rev().enumerate() {
                let mul = (c1 as u32 - '0' as u32) * (c2 as u32 - '0' as u32);
                let sum = mul + res[i + j] as u32;
                res[i + j] = (sum % 10) as u8;
                res[i + j + 1] += (sum / 10) as u8;
            }
        }
        let mut i = res.len() - 1;
        while res[i] == 0 { i -= 1; }
        res[0..=i].iter().rev().map(|c| (*c as char).to_string()).collect()
    }
}