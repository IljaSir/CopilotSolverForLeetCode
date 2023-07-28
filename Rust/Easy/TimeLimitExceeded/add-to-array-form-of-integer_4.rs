impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut num = num;
        let mut k = k;
        let mut carry = 0;
        let mut i = num.len();
        while i > 0 || k > 0 || carry > 0 {
            i -= 1;
            let mut digit = carry;
            if i < num.len() {
                digit += num[i];
            }
            if k > 0 {
                digit += k % 10;
                k /= 10;
            }
            carry = digit / 10;
            digit %= 10;
            if i < num.len() {
                num[i] = digit;
            } else {
                num.insert(0, digit);
            }
        }
        num
    }
}