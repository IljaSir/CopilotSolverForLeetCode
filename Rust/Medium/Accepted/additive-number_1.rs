impl Solution {
    pub fn is_additive_number(num: String) -> bool {
        

        let num = num.as_bytes();
        let n = num.len();
        let mut ans = false;
        for i in 1..n {
            if num[0] == b'0' && i > 1 {
                break;
            }
            for j in i+1..n {
                if num[i] == b'0' && j > i + 1 {
                    break;
                }
                let a = num[..i].iter().fold(0, |a, b| a * 10 + (b - b'0') as i64);
                let b = num[i..j].iter().fold(0, |a, b| a * 10 + (b - b'0') as i64);
                ans = ans || Self::dfs(&num[j..], a, b);
                if ans {
                    break;
                }
            }
            if ans {
                break;
            }
        }
        ans
    }
    fn dfs(num: &[u8], a: i64, b: i64) -> bool {
        if num.len() == 0 {
            return true;
        }
        let c = a + b;
        let s = c.to_string().into_bytes();
        if s.len() > num.len() {
            return false;
        }
        if s != num[..s.len()] {
            return false;
        }
        Self::dfs(&num[s.len()..], b, c)
    }
}