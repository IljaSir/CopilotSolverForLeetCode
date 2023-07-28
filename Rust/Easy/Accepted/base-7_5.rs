impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        let mut n = num;
        let mut res = String::new();
        let mut sign = "";
        if n < 0 {
            sign = "-";
            n = -n;
        }
        while n >= 7 {
            res = format!("{}{}", n % 7, res);
            n /= 7;
        }
        res = format!("{}{}{}", sign, n, res);
        res
    }
}