impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut res = 0;
        let mut num = num;
        if num < 0 {
            num = -num;
            res = -res;
        }
        let mut a: Vec<i32> = vec![];
        while num > 0 {
            a.push((num % 10) as i32);
            num /= 10;
        }
        a.sort();
        for i in a {
            res = res * 10 + i as i64;
        }
        res
    }
}