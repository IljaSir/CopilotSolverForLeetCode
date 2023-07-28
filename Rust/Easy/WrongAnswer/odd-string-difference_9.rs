impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut res = String::from("");
        let mut odd = false;
        let mut diff = 0;
        for i in 0..words.len() {
            let mut tmp = Vec::new();
            for j in 0..words[i].len() - 1 {
                tmp.push(words[i].as_bytes()[j + 1] - words[i].as_bytes()[j]);
            }
            println!("{:?}", tmp);
            let mut odd_tmp = false;
            for k in 0..tmp.len() {
                if k == 0 {
                    diff = tmp[k];
                } else {
                    if tmp[k] != diff {
                        odd_tmp = true;
                        break;
                    }
                }
            }
            if odd_tmp {
                odd = true;
                res = words[i].clone();
                break;
            }
        }
        if odd {
            res
        } else {
            String::from("")
        }
    }
}