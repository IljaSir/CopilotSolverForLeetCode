impl Solution {
    pub fn is_additive_number(num: String) -> bool {
        

        let mut i = 1;
        let mut j = 1;
        let mut num: Vec<char> = num.chars().collect();
        if num.len() < 3 {
            return false;
        }
        while i <= num.len() / 2 {
            while j <= num.len() / 2 {
                let mut a = num[..i].to_vec();
                let mut b = num[i..i + j].to_vec();
                let mut k = i + j;
                let mut c = Self::add(a, b);
                let mut c_str = c.iter().collect::<String>();
                let mut c_len = c_str.len();
                while k + c_len <= num.len() && c_str == num[k..k + c_len].iter().collect::<String>() {
                    k += c_len;
                    a = b;
                    b = c;
                    c = Self::add(a, b);
                    c_str = c.iter().collect::<String>();
                    c_len = c_str.len();
                }
                if k == num.len() {
                    return true;
                }
                j += 1;
            }
            i += 1;
            j = 1;
        }
        false
    }
    fn add(a: Vec<char>, b: Vec<char>) -> Vec<char> {
        let mut i = a.len() - 1;
        let mut j = b.len() - 1;
        let mut carry = 0;
        let mut result: Vec<char> = Vec::new();
        while i >= 0 || j >= 0 {
            let mut sum = carry;
            if i >= 0 {
                sum += a[i] as u8 - '0' as u8;
                i -= 1;
            }
            if j >= 0 {
                sum += b[j] as u8 - '0' as u8;
                j -= 1;
            }
            carry = sum / 10;
            result.push((sum % 10 + '0' as u8) as char);
        }
        if carry > 0 {
            result.push((carry + '0' as u8) as char);
        }
        result.reverse();
        result
    }
}