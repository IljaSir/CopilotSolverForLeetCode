impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        
        let mut ans = Vec::new();
        let mut i = 0;
        let mut n = words.len();
        while i < n {
            let mut j = i + 1;
            let mut len = words[i].len();
            while j < n && len + words[j].len() + 1 <= max_width as usize {
                len += words[j].len() + 1;
                j += 1;
            }
            let mut line = words[i].clone();
            let is_last = j == n;
            let mut space = max_width as usize - len;
            let mut space_num = j - i - 1;
            if is_last || space_num == 0 {
                for k in i + 1..j {
                    line.push(' ');
                    line.push_str(&words[k]);
                }
                for _ in 0..space {
                    line.push(' ');
                }
            } else {
                let mut avg_space = space / space_num;
                let mut left = space % space_num;
                for k in i + 1..j {
                    for _ in 0..avg_space {
                        line.push(' ');
                    }
                    if left > 0 {
                        line.push(' ');
                        left -= 1;
                    }
                    line.push_str(&words[k]);
                }
            }
            ans.push(line);
            i = j;
        }
        ans
    }
}