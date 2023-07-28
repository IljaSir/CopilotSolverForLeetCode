impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        let mut ans = String::from("");
        let mut i = 0;
        let mut flag = false;
        loop {
            let mut ch = ' ';
            for s in &strs {
                if i >= s.len() {
                    flag = true;
                    break;
                }
                if ch == ' ' {
                    ch = s.chars().nth(i).unwrap();
                } else if ch != s.chars().nth(i).unwrap() {
                    flag = true;
                    break;
                }
            }
            if flag {
                break;
            }
            ans.push(ch);
            i += 1;
        }
        ans
    }
}