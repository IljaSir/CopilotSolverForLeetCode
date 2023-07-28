impl Solution {
    pub fn split_into_fibonacci(num: String) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut n = num.as_bytes();
        let mut i = 0;
        while i < n.len() {
            let mut j = i + 1;
            while j < n.len() {
                if n[i] == b'0' && j > i + 1 {
                    break;
                }
                let mut k = j + 1;
                let mut a = String::from_utf8(n[i..j].to_vec()).unwrap().parse::<i32>().unwrap();
                let mut b = String::from_utf8(n[j..k].to_vec()).unwrap().parse::<i32>().unwrap();
                result.push(a);
                result.push(b);
                while k < n.len() {
                    let c = a + b;
                    let c = c.to_string();
                    let c = c.as_bytes();
                    if k + c.len() > n.len() || n[k..k+c.len()] != c {
                        break;
                    }
                    k += c.len();
                    a = b;
                    b = String::from_utf8(c.to_vec()).unwrap().parse::<i32>().unwrap();
                    result.push(b);
                }
                if k == n.len() && result.len() >= 3 {
                    return result;
                }
                result.clear();
                j += 1;
            }
            i += 1;
        }
        result
    }
}