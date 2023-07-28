impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut s = vec!['a', 'b', 'c'];
        let mut res = String::new();
        let mut k = k;
        for _ in 0..n {
            let mut next = vec![];
            for i in 0..3 {
                if res.is_empty() || s[i] != res.chars().last().unwrap() {
                    next.push(s[i]);
                }
            }
            if k > next.len() as i32 {
                k -= next.len() as i32;
                res.clear();
                break;
            }
            res.push(next[(k - 1) as usize]);
            k = 1;
        }
        res
    }
}