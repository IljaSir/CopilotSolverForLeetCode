impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num = num.to_string();
        let mut digits = [0; 10];
        let mut sum = 0;
        for c in num.chars() {
            digits[c as usize - '0' as usize] += 1;
            sum += (c as usize - '0' as usize) as i32;
        }
        let mut res = sum;

        for c in num.chars() {
            let d = c as usize - '0' as usize;
            digits[d] -= 1;
            sum -= d as i32;
            let mut tmp = sum;
            for i in 0..10 {
                tmp += (digits[i] + 1) / 2 * i as i32;
            }
            res = res.min(tmp);
        }
        return res;
    }
}