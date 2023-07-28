impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut logs = logs;
        logs.sort_by(|a, b| {
            let mut a_iter = a.split_whitespace();
            let mut b_iter = b.split_whitespace();
            let a_id = a_iter.next().unwrap();
            let b_id = b_iter.next().unwrap();
            let a_rest = a_iter.collect::<Vec<&str>>().join(" ");
            let b_rest = b_iter.collect::<Vec<&str>>().join(" ");
            if a_rest.chars().next().unwrap().is_digit(10) {
                if b_rest.chars().next().unwrap().is_digit(10) {
                    Ordering::Equal
                } else {
                    Ordering::Greater
                }
            } else {
                if b_rest.chars().next().unwrap().is_digit(10) {
                    Ordering::Less
                } else {
                    if a_rest == b_rest {
                        a_id.cmp(b_id)
                    } else {
                        a_rest.cmp(&b_rest)
                    }
                }
            }
        });
        logs
    }
}