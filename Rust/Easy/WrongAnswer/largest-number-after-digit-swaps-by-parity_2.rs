impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut num = num;
        let mut v = vec![];
        while num > 0 {
            v.push(num % 10);
            num /= 10;
        }
        v.sort_by(|a, b| b.cmp(a));
        let mut res = 0;
        for &n in v.iter() {
            res = res * 10 + n;
        }
        res
    }
}