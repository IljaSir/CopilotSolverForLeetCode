impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        chars.sort();
        let mut res = String::new();
        let mut flag = true;
        while !chars.is_empty() {
            let mut last = chars[0];
            res.push(last);
            chars.remove(0);
            let mut i = 0;
            while i < chars.len() {
                if flag && chars[i] > last || !flag && chars[i] < last {
                    last = chars[i];
                    res.push(last);
                    chars.remove(i);
                } else {
                    i += 1;
                }
            }
            flag = !flag;
        }
        res
    }
}