impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut logs = logs;
        logs.sort_by(|a, b| {
            let a = a.split(' ').collect::<Vec<_>>();
            let b = b.split(' ').collect::<Vec<_>>();
            let a_is_digit = a[1].chars().next().unwrap().is_digit(10);
            let b_is_digit = b[1].chars().next().unwrap().is_digit(10);
            if a_is_digit && b_is_digit {
                Ordering::Equal
            } else if a_is_digit {
                Ordering::Greater
            } else if b_is_digit {
                Ordering::Less
            } else {
                let a = &a[1..];
                let b = &b[1..];
                if a == b {
                    a[0].cmp(b[0])
                } else {
                    a.cmp(b)
                }
            }
        });
        logs
    }
}