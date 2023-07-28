impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut res = String::new();
        let mut num = num;
        let mut i = 0;
        let map = vec![("M", 1000), ("CM", 900), ("D", 500), ("CD", 400), ("C", 100), ("XC", 90), ("L", 50), ("XL", 40), ("X", 10), ("IX", 9), ("V", 5), ("IV", 4), ("I", 1)];
        while num > 0 {
            if num >= map[i].1 {
                res.push_str(map[i].0);
                num -= map[i].1;
            } else {
                i += 1;
            }
        }
        res
    }
}