impl Solution {
    pub fn split_into_fibonacci(num: String) -> Vec<i32> {
        
        let mut res = vec![];
        let mut num = num.as_bytes();
        let n = num.len();
        let mut first = 0;
        let mut second = 1;
        while first < n {
            second = first + 1;
            while second < n {
                let mut third = second + 1;
                let mut a = 0;
                let mut b = 0;
                let mut c = 0;
                let mut ok = true;
                while third < n {
                    if num[third] == b'0' && (c > 0 || third == second + 1) {
                        ok = false;
                        break;
                    }
                    c = c * 10 + (num[third] - b'0') as i32;
                    if c > a + b {
                        ok = false;
                        break;
                    }
                    if c == a + b {
                        if third == n - 1 {
                            res.push(a);
                            res.push(b);
                            res.push(c);
                            return res;
                        }
                        a = b;
                        b = c;
                        c = 0;
                    }
                    third += 1;
                }
                if !ok {
                    break;
                }
                second += 1;
            }
            first += 1;
        }
        res
    }
}