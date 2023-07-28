impl Solution {
    pub fn nearest_palindromic(n: String) -> String {
        
        let n: i64 = n.parse().unwrap();
        let mut candidates = vec![0; 4];
        let mut prefix = n / 10i64.pow((n.to_string().len() - 1) as u32);
        let mut suffix = n - prefix * 10i64.pow((n.to_string().len() - 1) as u32);
        let mut prefix = prefix.to_string();
        let mut suffix = suffix.to_string();
        if suffix.len() == 0 {
            suffix = "0".to_string();
        }
        if suffix.len() == 1 {
            suffix = "0".to_string();
        }
        let mut prefix = prefix.parse::<i64>().unwrap();
        let mut suffix = suffix.parse::<i64>().unwrap();
        candidates[0] = prefix * 10i64.pow((n.to_string().len() - 1) as u32) + suffix;
        if prefix > 1 {
            prefix -= 1;
            suffix = 10i64.pow((n.to_string().len() - 1) as u32) - 1;
            candidates[1] = prefix * 10i64.pow((n.to_string().len() - 1) as u32) + suffix;
        } else {
            candidates[1] = 10i64.pow((n.to_string().len() - 1) as u32) - 1;
        }
        prefix = n / 10i64.pow((n.to_string().len() - 1) as u32);
        suffix = n - prefix * 10i64.pow((n.to_string().len() - 1) as u32);
        let mut prefix = prefix.to_string();
        let mut suffix = suffix.to_string();
        if suffix.len() == 0 {
            suffix = "0".to_string();
        }
        if suffix.len() == 1 {
            suffix = "0".to_string();
        }
        let mut prefix = prefix.parse::<i64>().unwrap();
        let mut suffix = suffix.parse::<i64>().unwrap();
        candidates[2] = prefix * 10i64.pow((n.to_string().len() - 1) as u32) + suffix;
        if prefix > 1 {
            prefix -= 1;
            suffix = 10i64.pow((n.to_string().len() -
    }
}