impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut sw = vec![];
        for w in start_words {
            let mut tmp = vec![0; 26];
            for c in w.chars() {
                tmp[c as usize - 'a' as usize] += 1;
            }
            sw.push(tmp);
        }
        let mut tw = vec![];
        for w in target_words {
            let mut tmp = vec![0; 26];
            for c in w.chars() {
                tmp[c as usize - 'a' as usize] += 1;
            }
            tw.push(tmp);
        }
        for i in 0..tw.len() {
            let mut flag = false;
            for j in 0..sw.len() {
                let mut tmp = sw[j].clone();
                let mut f = true;
                for k in 0..26 {
                    if tw[i][k] > tmp[k] {
                        f = false;
                        break;
                    }
                    tmp[k] -= tw[i][k];
                }
                if f {
                    flag = true;
                    break;
                }
            }
            if flag {
                res += 1;
            }
        }
        res
    }
}