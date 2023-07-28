impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        

        let mut result = vec![0;num1.len()+num2.len()];
        let num1: Vec<char> = num1.chars().collect();
        let num2: Vec<char> = num2.chars().collect();
        for i in 0..num1.len() {
            for j in 0..num2.len() {
                let n1 = num1[num1.len()-1-i].to_digit(10).unwrap();
                let n2 = num2[num2.len()-1-j].to_digit(10).unwrap();
                result[i+j] += n1*n2;
            }
        }
        let mut carry = 0;
        for i in 0..result.len() {
            result[i] += carry;
            carry = result[i]/10;
            result[i] %= 10;
        }
        while result.len() > 1 && result[result.len()-1] == 0 {
            result.pop();
        }
        result.reverse();
        result.iter().map(|&c| (c as u8 + '0' as u8) as char).collect()
    }
}