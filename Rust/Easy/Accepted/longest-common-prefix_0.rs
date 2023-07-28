impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        if strs.len() == 0 {
            return "".to_string();
        }
        let mut min_len = strs[0].len();
        for i in 1..strs.len() {
            if strs[i].len() < min_len {
                min_len = strs[i].len();
            }
        }
        let mut res = String::from("");
        for i in 0..min_len {
            let mut flag = true;
            let mut ch = ' ';
            for j in 0..strs.len() {
                if j == 0 {
                    ch = strs[j].chars().nth(i).unwrap();
                } else {
                    if ch != strs[j].chars().nth(i).unwrap() {
                        flag = false;
                        break;
                    }
                }
            }
            if flag {
                res.push(ch);
            } else {
                break;
            }
        }
        res
    }
}