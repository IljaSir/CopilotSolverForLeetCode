impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut num = num;
        let mut res = String::new();
        let mut i = 0;
        let nums = vec![1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
        let romans = vec!["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];
        while num > 0 {
            let times = num / nums[i];
            for _ in 0..times {
                res += romans[i];
            }
            num -= times * nums[i];
            i += 1;
        }
        res
    }
}