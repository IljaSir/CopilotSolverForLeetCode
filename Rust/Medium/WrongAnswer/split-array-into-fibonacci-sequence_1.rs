impl Solution {
    pub fn split_into_fibonacci(num: String) -> Vec<i32> {
        
        let num = num.as_bytes();
        let n = num.len();
        let mut res: Vec<i32> = Vec::new();
        for i in 0..n-2 {
            if i > 0 && num[0] == b'0' { break; }
            let a = i32::from_str_radix(std::str::from_utf8(&num[0..=i]).unwrap(), 10).unwrap();
            for j in i+1..n-1 {
                if j > i+1 && num[i+1] == b'0' { break; }
                let b = i32::from_str_radix(std::str::from_utf8(&num[i+1..=j]).unwrap(), 10).unwrap();
                res.clear();
                res.push(a);
                res.push(b);
                let mut k = j+1;
                loop {
                    let c = res[res.len()-2] + res[res.len()-1];
                    let c = c.to_string().into_bytes();
                    if k + c.len() > n { break; }
                    if c == &num[k..k+c.len()] {
                        k += c.len();
                        res.push(i32::from_str_radix(std::str::from_utf8(&c).unwrap(), 10).unwrap());
                        if k == n { return res; }
                    } else {
                        break;
                    }
                }
            }
        }
        res
    }
}