impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut res = vec![];
        let mut dic = vec![];
        for s in dictionary {
            dic.push(s);
        }
        for s in queries {
            if dic.contains(&s) {
                res.push(s);
            } else {
                let mut flag = false;
                for i in 0..s.len() {
                    let mut s1 = s.clone();
                    s1.remove(i);
                    if dic.contains(&s1) {
                        res.push(s);
                        flag = true;
                        break;
                    }
                }
                if !flag {
                    for i in 0..s.len() {
                        for j in i+1..s.len() {
                            let mut s1 = s.clone();
                            s1.remove(i);
                            s1.remove(j-1);
                            if dic.contains(&s1) {
                                res.push(s);
                                flag = true;
                                break;
                            }
                        }
                        if flag { break; }
                    }
                }
            }
        }
        res
    }
}