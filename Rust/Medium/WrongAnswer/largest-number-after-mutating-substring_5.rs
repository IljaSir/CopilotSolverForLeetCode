impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut res = String::from("");
        let mut flag = false;
        for c in num.chars() {
            let i = c as usize - 48;
            if change[i] > i as i32 {
                res.push_str(&change[i].to_string());
                flag = true;
            } else if change[i] < i as i32 {
                if flag {
                    res.push_str(&i.to_string());
                } else {
                    res.push_str(&c.to_string());
                }
            } else {
                res.push_str(&c.to_string());
            }
        }
        res
    }
}