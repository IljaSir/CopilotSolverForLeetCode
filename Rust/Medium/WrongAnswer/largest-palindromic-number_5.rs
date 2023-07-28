impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let mut n = num.len();
        let mut v = num.chars().collect::<Vec<char>>();
        v.sort();
        v.reverse();
        if v[0] == '0' {
            return "0".to_string();
        }
        let mut i = 0;
        while i < n {
            if v[i] != '0' {
                break;
            }
            i += 1;
        }
        if i > 0 {
            let t = v[0];
            v[0] = v[i];
            v[i] = t;
        }
        v.iter().collect::<String>()
    }
}