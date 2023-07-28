impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut carry = 0;
        let mut k = k;
        let mut res = Vec::new();
        for i in (0..num.len()).rev() {
            let mut sum = num[i] + (k % 10) + carry;
            k /= 10;
            if sum >= 10 {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res.push(sum);
        }
        while k > 0 {
            let mut sum = k % 10 + carry;
            k /= 10;
            if sum >= 10 {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res.push(sum);
        }
        if carry > 0 {
            res.push(carry);
        }
        res.reverse();
        res
    }
}