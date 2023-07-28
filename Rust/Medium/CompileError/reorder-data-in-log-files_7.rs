impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut ans = logs.clone();
        ans.sort_by(|a, b| {
            let a: Vec<&str> = a.split_whitespace().collect();
            let b: Vec<&str> = b.split_whitespace().collect();
            if a[1].chars().all(|c| c.is_digit(10)) && b[1].chars().all(|c| c.is_digit(10)) {
                return std::cmp::Ordering::Equal;
            } else if a[1].chars().all(|c| c.is_digit(10)) {
                return std::cmp::Ordering::Greater;
            } else if b[1].chars().all(|c| c.is_digit(10)) {
                return std::cmp::Ordering::Less;
            } else {
                let a = a[1..].join(" ");
                let b = b[1..].join(" ");
                if a == b {
                    a[0].cmp(&b[0])
                } else {
                    a.cmp(&b)
                }
            }
        });
        ans
    }
}